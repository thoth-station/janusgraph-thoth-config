graph.tx().rollback() //Never create new indexes while a transaction is active

mgmt = graph.openManagement()

if (mgmt.getGraphIndex("byDependsOn") == null) {
  /*
  * Properties.
  */
  lbl = mgmt.getPropertyKey('__label__')
  type = mgmt.getPropertyKey('__type__')
  version_range = mgmt.getPropertyKey('version_range')
  package_name = mgmt.getPropertyKey('package_name')
  extras = mgmt.getPropertyKey('extras')

  // No property edges match.
  mgmt.buildIndex('byDependsOn', Edge.class) \
   .addKey(lbl) \
   .addKey(type) \
   .addKey(version_range) \
   .addKey(package_name) \
   .addKey(extras) \
   .buildCompositeIndex()

  // Make changes! \o/
  mgmt.commit()
}

println "byDependsOn index creation done!"