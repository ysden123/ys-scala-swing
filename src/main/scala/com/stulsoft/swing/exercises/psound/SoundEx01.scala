/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.exercises.psound

import java.io.File
import javax.sound.sampled.*
import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

object SoundEx01:
  def main(args: Array[String]): Unit = {
    given ExecutionContext = ExecutionContext.global

    Future {
      println("In future")
      val clip = AudioSystem.getClip()
      val file = new File(getClass.getClassLoader.getResource("sounds/success-fanfare-trumpets-6185.wav").toURI)
      clip.open(AudioSystem.getAudioInputStream(file))
      clip.start()
      clip.wait()
      println("End of future")
    }.onComplete {
      case Failure(exception) => println(exception.getMessage)
      case Success(_) => println("completed")
    }

    Thread.sleep(5000)
  }
