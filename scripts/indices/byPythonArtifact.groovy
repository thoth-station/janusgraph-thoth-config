graph.tx().rollback() // Never create new indexes while a transaction is active

mgmt = graph.openManagement()

if (mgmt.getGraphIndex("byPythonArtifact") == null) {
  /*
   * Properties.
   */
  lbl = mgmt.getPropertyKey('__label__')
  type = mgmt.getPropertyKey('__type__')

  artifact_hash_sha256 = mgmt.getPropertyKey('artifact_hash_sha256')

  /*
   * Indexes.
   */
  // Exact match for PythonArtifact.
  mgmt.buildIndex('byPythonArtifact', Vertex.class) \
   .addKey(lbl) \
   .addKey(type) \
   .addKey(artifact_hash_sha256) \
   .buildCompositeIndex()

  // Make changes! \o/
  mgmt.commit()
}

println "byPythonArtifact index creation done!"
