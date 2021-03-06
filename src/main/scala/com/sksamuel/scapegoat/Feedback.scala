package com.sksamuel.scapegoat

import scala.collection.mutable.ListBuffer
import scala.reflect.api.Position

/** @author Stephen Samuel */
class Feedback(consoleOutput: Boolean) {

  val warnings = new ListBuffer[Warning]

  def infos = warnings(Levels.Info)
  def errors = warnings(Levels.Error)
  def warns = warnings(Levels.Warning)
  def warnings(level: Level): Seq[Warning] = warnings.filter(_.level == level)

  def warn(text: String, pos: Position, level: Level, inspection: Inspection): Unit = {
    warn(text, pos, level, None, inspection)
  }

  def warn(text: String, pos: Position, level: Level, snippet: String, inspection: Inspection): Unit = {
    warn(text, pos, level, Option(snippet), inspection)
  }

  private def warn(text: String,
    pos: Position,
    level: Level,
    snippet: Option[String],
    inspection: Inspection): Unit = {
    val sourceFile = normalizeSourceFile(pos.source.file.path)
    val warning = Warning(text, pos.line, level, sourceFile, snippet, inspection.getClass.getCanonicalName)
    warnings.append(warning)
    if (consoleOutput) {
      println(s"[${warning.level.toString.toLowerCase}] $sourceFile:${warning.line}: $text")
      snippet.foreach(s => println(s"          $s"))
      println()
    }
  }

  private def normalizeSourceFile(sourceFile: String): String = {
    val indexOf = sourceFile.indexOf("src/main/scala/")
    val packageAndFile = if (indexOf == -1) sourceFile else sourceFile.drop(indexOf).drop("src/main/scala/".length)
    packageAndFile.replace('/', '.').replace('\\', '.')
  }
}

case class Warning(text: String,
  line: Int,
  level: Level,
  sourceFile: String,
  snippet: Option[String],
  inspection: String)
