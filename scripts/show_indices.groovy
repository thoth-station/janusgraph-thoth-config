:remote connect tinkerpop.server conf/remote.yaml session
:remote console

mgmt = graph.openManagement()

indexes = [
  'byCVE',
  'byDebPackageVersion',
  'byDependsOn',
  'byEcosystemSolver',
  'byEdge',
  'byIsPartOf',
  'byPackage',
  'byPythonArtifact',
  'byPythonPackageVersion',
  'byRequires',
  'byRPMPackageVersion',
  'byRPMRequirement',
  'byRuntimeEnvironment',
  'bySolved',
  'bySoftwareStack',
]

indexes.each { i ->
  index = mgmt.getGraphIndex(i)
  println(index)
}
