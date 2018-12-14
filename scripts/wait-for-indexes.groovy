graph.tx().rollback()

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
  'bySoftwareStack'
]

indexes.each { i ->
  index = mgmt.getGraphIndex(i)
  propertykeys = index.getFieldKeys()
  propertykeys.each { j ->
    indexof = propertykeys.findIndexOf{ it ==~ j}

    indexcurrentstatus = index.getIndexStatus(propertykeys[indexof])
    if (indexcurrentstatus == SchemaStatus.REGISTERED) {
      System.err.println "Schema Status is in REGISTERED mode"
      mgmt.awaitGraphIndexStatus(graph, i).status(SchemaStatus.ENABLED).call()
    }
  }
}
