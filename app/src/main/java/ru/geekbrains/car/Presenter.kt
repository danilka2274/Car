package ru.geekbrains.car

import android.view.animation.LinearInterpolator
import android.view.animation.OvershootInterpolator
import ru.geekbrains.car.databinding.ActivityMainBinding
import ru.geekbrains.car.Presenter.Way.*

class Presenter(private val bind: ActivityMainBinding) {

    fun pressedUp() {
        bind.up.setOnClickListener {
            rotation(UP)
            bind.car.animate()
                .translationYBy(-MOVE_DISTANCE)
                .setDuration(MOVE_DURATION)
                .setInterpolator(LinearInterpolator())
                .start()
        }
    }

    fun pressedDown() {
        bind.down.setOnClickListener {
            rotation(DOWN)
            bind.car.animate()
                .translationYBy(MOVE_DISTANCE)
                .setDuration(MOVE_DURATION)
                .setInterpolator(LinearInterpolator())
                .start()
        }
    }

    fun pressedLeft() {
        rotation(LEFT)
        bind.car.animate()
            .translationXBy(-MOVE_DISTANCE)
            .setDuration(MOVE_DURATION)
            .setInterpolator(LinearInterpolator())
            .start()
    }

    fun pressedRight() {
        rotation(RIGHT)
        bind.car.animate()
            .translationXBy(MOVE_DISTANCE)
            .setDuration(MOVE_DURATION)
            .setInterpolator(LinearInterpolator())
            .start()
    }

    private fun rotation(way: Way) {
        bind.car.animate()
            .rotation(
                when (way) {
                    UP -> 180f
                    DOWN -> 0f
                    LEFT -> 90f
                    RIGHT -> 270f
                }
            )
            .setDuration(500)
            .setInterpolator(OvershootInterpolator())
            .start()
    }

    enum class Way {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    companion object {
        const val MOVE_DURATION = 1000L
        const val MOVE_DISTANCE = 100f
    }
}