graph.tx().rollback() //Never create new indexes while a transaction is active

mgmt = graph.openManagement()

if (mgmt.getGraphIndex("byPythonPackageVersion") == null) {
  /*
  * Properties.
  */
  lbl = mgmt.getPropertyKey('__label__')
  type = mgmt.getPropertyKey('__type__')

  ecosystem = mgmt.getPropertyKey('ecosystem')
  package_name = mgmt.getPropertyKey('package_name')
  package_version = mgmt.getPropertyKey('package_version')
  index_url = mgmt.getPropertyKey('index_url')

  /*
  * Indexes.
  */
  //Exact match for PythonPackageVersion.
  mgmt.buildIndex('byPythonPackageVersion', Vertex.class) \
   .addKey(lbl) \
   .addKey(type) \
   .addKey(ecosystem) \
   .addKey(package_name) \
   .addKey(package_version) \
   .addKey(index_url) \
   .buildCompositeIndex()

  // Make changes! \o/
  mgmt.commit()
}

println "byPythonPackageVersion index creation done!"