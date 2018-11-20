graph.tx().rollback() //Never create new indexes while a transaction is active

mgmt = graph.openManagement()

if (mgmt.getGraphIndex("byEdge") == null) {
  /*
  * Properties.
  */
  lbl = mgmt.getPropertyKey('__label__')
  type = mgmt.getPropertyKey('__type__')

  // No property edges match.
  mgmt.buildIndex('byEdge', Edge.class) \
   .addKey(lbl) \
   .addKey(type) \
   .buildCompositeIndex()

  // Make changes! \o/
  mgmt.commit()
}

println "byEdge index creation done!"