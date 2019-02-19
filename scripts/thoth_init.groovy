mgmt = graph.openManagement()

mgmt.makeVertexLabel('adviser_software_stack').make()
mgmt.makeVertexLabel('build_observation').make()
mgmt.makeVertexLabel('buildtime_environment').make()
mgmt.makeVertexLabel('cve').make()
mgmt.makeVertexLabel('deb_package_version').make()
mgmt.makeVertexLabel('ecosystem_solver').make()
mgmt.makeVertexLabel('hardware_information').make()
mgmt.makeVertexLabel('inspection_software_stack').make()
mgmt.makeVertexLabel('package').make()
mgmt.makeVertexLabel('python_artifact').make()
mgmt.makeVertexLabel('python_package_index').make()
mgmt.makeVertexLabel('python_package_version').make()
mgmt.makeVertexLabel('rpm_package_version').make()
mgmt.makeVertexLabel('rpm_requirement').make()
mgmt.makeVertexLabel('runtime_environment').make()
mgmt.makeVertexLabel('software_stack_observation').make()
mgmt.makeVertexLabel('user_software_stack').make()

mgmt.makeEdgeLabel('builds_in').make()
mgmt.makeEdgeLabel('builds_on').make()
mgmt.makeEdgeLabel('creates_stack').make()
mgmt.makeEdgeLabel('deb_depends').make()
mgmt.makeEdgeLabel('deb_pre_depends').make()
mgmt.makeEdgeLabel('deb_replaces').make()
mgmt.makeEdgeLabel('depends_on').make()
mgmt.makeEdgeLabel('has_version').make()
mgmt.makeEdgeLabel('has_vulnerability').make()
mgmt.makeEdgeLabel('is_part_of').make()
mgmt.makeEdgeLabel('observed').make()
mgmt.makeEdgeLabel('requires').make()
mgmt.makeEdgeLabel('runs_in').make()
mgmt.makeEdgeLabel('runs_on').make()
mgmt.makeEdgeLabel('solved').make()

adviser_error = mgmt.makePropertyKey('adviser_error').dataType(Boolean.class).cardinality(Cardinality.SINGLE).make()
adviser_stack_index = mgmt.makePropertyKey('adviser_stack_index').dataType(Integer.class).cardinality(Cardinality.SINGLE).make()
advisory = mgmt.makePropertyKey('advisory').dataType(String.class).cardinality(Cardinality.SINGLE).make()
analysis_datetime = mgmt.makePropertyKey('analysis_datetime').dataType(Integer.class).make()
analysis_document_id = mgmt.makePropertyKey('analysis_document_id').dataType(String.class).make()
analyzer_name = mgmt.makePropertyKey('analyzer_name').dataType(String.class).make()
analyzer_version = mgmt.makePropertyKey('analyzer_version').dataType(String.class).make()
arch = mgmt.makePropertyKey('arch').dataType(String.class).cardinality(Cardinality.SINGLE).make()
artifact_hash_sha256 = mgmt.makePropertyKey('artifact_hash_sha256').dataType(String.class).cardinality(Cardinality.SINGLE).make()
build_error = mgmt.makePropertyKey('build_error').dataType(Boolean.class).make()
buildtime_environment_name = mgmt.makePropertyKey('buildtime_environment_name').dataType(String.class).cardinality(Cardinality.SINGLE).make()
cpu_cores = mgmt.makePropertyKey('cpu_cores').dataType(Integer.class).cardinality(Cardinality.SINGLE).make()
cpu_family = mgmt.makePropertyKey('cpu_family').dataType(Integer.class).cardinality(Cardinality.SINGLE).make()
cpu_model = mgmt.makePropertyKey('cpu_model').dataType(Integer.class).cardinality(Cardinality.SINGLE).make()
cpu_model_name = mgmt.makePropertyKey('cpu_model_name').dataType(String.class).cardinality(Cardinality.SINGLE).make()
cpu_physical_cpus = mgmt.makePropertyKey('cpu_physical_cpus').dataType(Integer.class).cardinality(Cardinality.SINGLE).make()
cuda_version = mgmt.makePropertyKey('cuda_version').dataType(String.class).cardinality(Cardinality.SINGLE).make()
cve_id = mgmt.makePropertyKey('cve_id').dataType(String.class).cardinality(Cardinality.SINGLE).make()
cve_name = mgmt.makePropertyKey('cve_name').dataType(String.class).cardinality(Cardinality.SINGLE).make()
document_id = mgmt.makePropertyKey('document_id').dataType(String.class).cardinality(Cardinality.SINGLE).make()
ecosystem = mgmt.makePropertyKey('ecosystem').dataType(String.class).cardinality(Cardinality.SINGLE).make()
epoch = mgmt.makePropertyKey('epoch').dataType(String.class).cardinality(Cardinality.SINGLE).make()
extras = mgmt.makePropertyKey('extras').dataType(String.class).make()
index_url = mgmt.makePropertyKey('index_url').dataType(String.class).cardinality(Cardinality.SINGLE).make()
inspection_document_id = mgmt.makePropertyKey('inspection_document_id').dataType(String.class).make()
origin = mgmt.makePropertyKey('origin').dataType(String.class).cardinality(Cardinality.SINGLE).make()
os_name = mgmt.makePropertyKey('os_name').dataType(String.class).cardinality(Cardinality.SINGLE).make()
os_version = mgmt.makePropertyKey('os_version').dataType(String.class).cardinality(Cardinality.SINGLE).make()
package_identifier = mgmt.makePropertyKey('package_identifier').dataType(String.class).cardinality(Cardinality.SINGLE).make()
package_name = mgmt.makePropertyKey('package_name').dataType(String.class).cardinality(Cardinality.SINGLE).make()
package_version = mgmt.makePropertyKey('package_version').dataType(String.class).cardinality(Cardinality.SINGLE).make()
performance_index = mgmt.makePropertyKey('performance_index').dataType(Float.class).cardinality(Cardinality.SINGLE).make()
python_version = mgmt.makePropertyKey('python_version').dataType(String.class).cardinality(Cardinality.SINGLE).make()
ram_size = mgmt.makePropertyKey('ram_size').dataType(Integer.class).cardinality(Cardinality.SINGLE).make()
release = mgmt.makePropertyKey('release').dataType(String.class).cardinality(Cardinality.SINGLE).make()
rpm_requirement_name = mgmt.makePropertyKey('rpm_requirement_name').dataType(String.class).cardinality(Cardinality.SINGLE).make()
run_error = mgmt.makePropertyKey('run_error').dataType(Boolean.class).make()
runtime_environment_name = mgmt.makePropertyKey('runtime_environment_name').dataType(String.class).cardinality(Cardinality.SINGLE).make()
solver_datetime = mgmt.makePropertyKey('solver_datetime').dataType(Integer.class).make()
solver_document_id = mgmt.makePropertyKey('solver_document_id').dataType(String.class).make()
solver_error = mgmt.makePropertyKey('solver_error').dataType(Boolean.class).make()
solver_error_unparsable = mgmt.makePropertyKey('solver_error_unparsable').dataType(Boolean.class).make()
solver_error_unsolvable = mgmt.makePropertyKey('solver_error_unsolvable').dataType(Boolean.class).make()
solver_name = mgmt.makePropertyKey('solver_name').dataType(String.class).cardinality(Cardinality.SINGLE).make()
solver_version = mgmt.makePropertyKey('solver_version').dataType(String.class).cardinality(Cardinality.SINGLE).make()
src = mgmt.makePropertyKey('src').dataType(Boolean.class).cardinality(Cardinality.SINGLE).make()
url = mgmt.makePropertyKey('url').dataType(String.class).cardinality(Cardinality.SINGLE).make()
verify_ssl = mgmt.makePropertyKey('verify_ssl').dataType(Boolean.class).cardinality(Cardinality.SINGLE).make()
version_range = mgmt.makePropertyKey('version_range').dataType(String.class).cardinality(Cardinality.SINGLE).make()
warehouse_api_url = mgmt.makePropertyKey('warehouse_api_url').dataType(String.class).cardinality(Cardinality.SINGLE).make()
lbl = mgmt.makePropertyKey('__label__').dataType(String.class).cardinality(Cardinality.SINGLE).make()
type = mgmt.makePropertyKey('__type__').dataType(String.class).cardinality(Cardinality.SINGLE).make()

mgmt.buildIndex('byEdge', Edge.class) \
    .addKey(lbl) \
    .addKey(type) \
    .buildCompositeIndex()

mgmt.buildIndex('byPackage', Vertex.class) \
    .addKey(lbl) \
    .addKey(type) \
    .addKey(ecosystem) \
    .addKey(package_name) \
    .buildCompositeIndex()

mgmt.buildIndex('byPythonPackageVersion', Vertex.class) \
    .addKey(lbl) \
    .addKey(type) \
    .addKey(ecosystem) \
    .addKey(package_name) \
    .addKey(package_version) \
    .addKey(index_url) \
    .indexOnly(python_package_version) \
    .buildCompositeIndex()

mgmt.buildIndex('byPythonPackageIndex', Vertex.class) \
    .addKey(lbl) \
    .addKey(type) \
    .addKey(url) \
    .addKey(warehouse_api_url) \
    .addKey(verify_ssl) \
    .addKey(warehouse) \
    .buildCompositeIndex()

mgmt.buildIndex('byPythonArtifact', Vertex.class) \
    .addKey(lbl) \
    .addKey(type) \
    .addKey(artifact_hash_sha256) \
    .buildCompositeIndex()

mgmt.buildIndex('byIsPartOf', Edge.class) \
    .addKey(lbl) \
    .addKey(type) \
    .addKey(analysis_datetime) \
    .addKey(analysis_document_id) \
    .addKey(analyzer_name) \
    .addKey(analyzer_version) \
    .buildCompositeIndex()

mgmt.buildIndex('byDependsOn', Edge.class) \
    .addKey(lbl) \
    .addKey(type) \
    .addKey(version_range) \
    .addKey(package_name) \
    .addKey(extras) \
    .buildCompositeIndex()

mgmt.buildIndex('byCVE', Vertex.class) \
    .addKey(lbl) \
    .addKey(type) \
    .addKey(version_range) \
    .addKey(advisory) \
    .addKey(cve_name) \
    .addKey(cve_id) \
    .buildCompositeIndex()

mgmt.buildIndex('bySolved', Edge.class) \
    .addKey(lbl) \
    .addKey(type) \
    .addKey(solver_datetime) \
    .addKey(solver_document_id) \
    .addKey(solver_error) \
    .addKey(solver_error_unsolvable) \
    .addKey(solver_error_unparsable) \
    .buildCompositeIndex()

mgmt.buildIndex('byRequires', Edge.class) \
    .addKey(lbl) \
    .addKey(type) \
    .addKey(analysis_datetime) \
    .addKey(analysis_document_id) \
    .addKey(analyzer_name) \
    .addKey(analyzer_version) \
    .buildCompositeIndex()

mgmt.buildIndex('byRuntimeEnvironment', Vertex.class) \
    .addKey(lbl) \
    .addKey(type) \
    .addKey(runtime_environment_name) \
    .buildCompositeIndex()

mgmt.buildIndex('byRPMRequirement', Vertex.class) \
    .addKey(lbl) \
    .addKey(type) \
    .addKey(rpm_requirement_name) \
    .buildCompositeIndex()

mgmt.buildIndex('byRPMPackageVersion', Vertex.class) \
    .addKey(lbl) \
    .addKey(type) \
    .addKey(ecosystem) \
    .addKey(package_name) \
    .addKey(package_version) \
    .addKey(release) \
    .addKey(epoch) \
    .addKey(arch) \
    .addKey(src) \
    .addKey(package_identifier) \
    .buildCompositeIndex()

mgmt.buildIndex('byEcosystemSolver', Vertex.class) \
    .addKey(lbl) \
    .addKey(type) \
    .addKey(solver_name) \
    .addKey(solver_version) \
    .buildCompositeIndex()

mgmt.buildIndex('byDebPackageVersion', Vertex.class) \
    .addKey(lbl) \
    .addKey(type) \
    .addKey(ecosystem) \
    .addKey(package_name) \
    .addKey(package_version) \
    .addKey(epoch) \
    .addKey(arch) \
    .buildCompositeIndex()

mgmt.buildIndex('bySoftwareStack', Vertex.class) \
    .addKey(lbl) \
    .addKey(type) \
    .addKey(software_stack_key) \
    .buildCompositeIndex()

mgmt.commit()
