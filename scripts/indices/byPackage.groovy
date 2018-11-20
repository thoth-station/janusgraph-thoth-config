graph.tx().rollback() //Never create new indexes while a transaction is active

mgmt = graph.openManagement()

if (mgmt.getGraphIndex("byPackage") == null) {
  /*
  * Properties.
  */
  lbl = mgmt.getPropertyKey('__label__')
  type = mgmt.getPropertyKey('__type__')

  ecosystem = mgmt.getPropertyKey('ecosystem')
  package_name = mgmt.getPropertyKey('package_name')

  /*
  * Indexes.
  */

  // Exact match for a Package search.
  mgmt.buildIndex('byPackage', Vertex.class) \
   .addKey(lbl) \
   .addKey(type) \
   .addKey(ecosystem) \
   .addKey(package_name) \
   .buildCompositeIndex()

  // Make changes! \o/
  mgmt.commit()
}

println "byPackage index creation done!"