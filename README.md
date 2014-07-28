Scapegoat
==========

Scapegoat is a Scala static code anaylzer, what is more colloquially known as a code lint tool. Scapegoat works in a similar vein to Java's [FindBugs](http://findbugs.sourceforge.net/) or [checkstyles](http://checkstyle.sourceforge.net/), or Scala's [Scalastyle](https://github.com/scalastyle/scalastyle).

A static code anaylzer is a tool that flag suspicious langage usage in code. This can include behavior likely to lead or bugs, non idiomatic usage of a language, or just code that doesn't conform to specified style guidelines.

**What's the difference between this project and Scalastyle?**

Scalastyle is a similar linting tool which focuses mostly on enforcing style/code standards. Scapegoat focuses mostly on static analysis at compile time. This means both projects are complimentary as they can detect different problems, although you might find both projects occassionally have a similar inspection.

### Usage
Scapegoat is developed as a scala compiler plugin, which can then be used inside your build tool.

See: [sbt-scapegoat](https://github.com/sksamuel/sbt-scapegoat) for SBT integration

### Screenshot

Here is a screen shot of the type of report scapegoat generates.

![screenshot](https://raw.githubusercontent.com/sksamuel/scapegoat/master/screenshot1.png)

### Inspections

The currently implemented inspections are as follows. Most of the descriptions need to be completed, but they should be self explanatary anyway from the name.

|Name|Description|
|----|-----------|
| As instance of | description needed |
| Blocking actor | check for use Await.result and Await.ready in actor |
| Broken oddness | checks for a % 2 == 1 for oddness, but this breaks for negative numbers |
| Catching NPE | checks for case clause catching NPE |
| Collection promotion to any | description needed |
| Comparing floating point types | description needed |
| Comparison with self | description needed |
| Constant if | checks for code where the expression on conditionals compiles to a constant |
| Either get | description needed |
| Empty Catch Block | description needed |
| Empty If Block | description needed |
| Empty Synchronized Block | description needed |
| Empty Method | description needed |
| Empty Try Block | description needed |
| Expresson as statement | executing an expression as a statement could be a mistake |
| filter.size instead of count | .filter(x => Bool).size can be replaced more concisely with with count(x => Bool) |
| Java conversions use | description needed |
| Mod one | checks for redundant x % 1 which always returns 0 |
| Null use | checks for use of null |
| Option Get | checks for improper use of Option.get |
| Parameterless method returns unit | checks for procedures (methods returning unit) that don't declare a params list |
| Prefer set empty | checks for use of Set.empty rather than Set() |
| Prefer seq empty | checks for use of Seq.empty rather than Seq() |
| Return use | using return in Scala is not recommended |
| Try get | Try.get should be replaced with safe patter matching |
| Unused method parameter | checks for unused method parameters |
| Var use | description needed |

