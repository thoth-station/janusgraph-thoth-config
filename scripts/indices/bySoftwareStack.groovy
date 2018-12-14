graph.tx().rollback() //Never create new indexes while a transaction is active

mgmt = graph.openManagement()

if (mgmt.getGraphIndex("bySoftwareStack") == null) {
  /*
  * Properties.
  */
  lbl = mgmt.getPropertyKey('__label__')
  type = mgmt.getPropertyKey('__type__')
  software_stack_name = mgmt.getPropertyKey('software_stack_name')

  // No property edges match.
  mgmt.buildIndex('bySoftwareStack', Vertex.class) \
   .addKey(lbl) \
   .addKey(type) \
   .addKey(software_stack_key) \
   .buildCompositeIndex()

  // Make changes! \o/
  mgmt.commit()
}

println "bySoftwareStack index creation done!"
