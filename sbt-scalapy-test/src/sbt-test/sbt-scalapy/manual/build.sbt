import scala.util.Properties

enablePlugins(ScalaPyPlugin)
libraryDependencies += "me.shadaj" %% "scalapy-core" % "0.5.2"

lazy val pythonExecutable = Properties.propOrNone("plugin.python.executable")

inThisBuild(
  pythonExecutable
    .map(p => Def.settings(scalapyPythonExecutable := p))
    .getOrElse(Def.settings())
)

lazy val python = ai.kien.python.Python(pythonExecutable)

scalapyPythonNativeLibrary := python.nativeLibrary.get
scalapyPythonNativeLibraryPaths := python.nativeLibraryPaths.get
