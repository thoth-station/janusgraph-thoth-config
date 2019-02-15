:remote connect tinkerpop.server conf/remote-test-4.yaml session
:remote console

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
]

graph.tx().rollback()

mgmt = graph.openManagement()

if (mgmt.getVertexLabel('package') == null) mgmt.makeVertexLabel('package').make()
if (mgmt.getVertexLabel('software_stack') == null) mgmt.makeVertexLabel('software_stack').make()
if (mgmt.getVertexLabel('python_package_index') == null) mgmt.makeVertexLabel('python_package_index').make()
if (mgmt.getVertexLabel('rpm_requirement') == null) mgmt.makeVertexLabel('rpm_requirement').make()
if (mgmt.getVertexLabel('runtime_environment') == null) mgmt.makeVertexLabel('runtime_environment').make()
if (mgmt.getVertexLabel('deb_package_version') == null) mgmt.makeVertexLabel('deb_package_version').make()
if (mgmt.getVertexLabel('buildtime_environment') == null) mgmt.makeVertexLabel('buildtime_environment').make()
if (mgmt.getVertexLabel('rpm_package_version') == null) mgmt.makeVertexLabel('rpm_package_version').make()
if (mgmt.getVertexLabel('ecosystem_solver') == null) mgmt.makeVertexLabel('ecosystem_solver').make()
if (mgmt.getVertexLabel('software_stack_observation') == null) mgmt.makeVertexLabel('software_stack_observation').make()
if (mgmt.getVertexLabel('hardware_information') == null) mgmt.makeVertexLabel('hardware_information').make()
if (mgmt.getVertexLabel('cve') == null) mgmt.makeVertexLabel('cve').make()
if (mgmt.getVertexLabel('python_artifact') == null) mgmt.makeVertexLabel('python_artifact').make()
if (mgmt.getVertexLabel('python_package_version') == null) python_package_version = mgmt.makeVertexLabel('python_package_version').make()

if (mgmt.getVertexLabel('software_stack_name') == null) mgmt.makeVertexLabel('software_stack_name').make()
if (mgmt.getEdgeLabel('has_version') == null) mgmt.makeEdgeLabel('has_version').make()
if (mgmt.getEdgeLabel('is_part_of') == null) mgmt.makeEdgeLabel('is_part_of').make()
if (mgmt.getEdgeLabel('runs_on') == null) mgmt.makeEdgeLabel('runs_on').make()
if (mgmt.getEdgeLabel('runs_in') == null) mgmt.makeEdgeLabel('runs_in').make()
if (mgmt.getEdgeLabel('builds_in') == null) mgmt.makeEdgeLabel('builds_in').make()
if (mgmt.getEdgeLabel('builds_on') == null) mgmt.makeEdgeLabel('builds_on').make()
if (mgmt.getEdgeLabel('depends_on') == null) mgmt.makeEdgeLabel('depends_on').make()
if (mgmt.getEdgeLabel('creates_stack') == null) mgmt.makeEdgeLabel('creates_stack').make()
if (mgmt.getEdgeLabel('requires') == null) mgmt.makeEdgeLabel('requires').make()
if (mgmt.getEdgeLabel('solved') == null) mgmt.makeEdgeLabel('solved').make()
if (mgmt.getEdgeLabel('runs_in') == null) mgmt.makeEdgeLabel('runs_in').make()
if (mgmt.getEdgeLabel('has_vulnerability') == null) mgmt.makeEdgeLabel('has_vulnerability').make()
if (mgmt.getEdgeLabel('deb_replaces') == null) mgmt.makeEdgeLabel('deb_replaces').make()
if (mgmt.getEdgeLabel('deb_depends') == null) mgmt.makeEdgeLabel('deb_depends').make()
if (mgmt.getEdgeLabel('deb_pre_depends') == null) mgmt.makeEdgeLabel('deb_pre_depends').make()
if (mgmt.getEdgeLabel('observation_document_id') == null) mgmt.makeEdgeLabel('observation_document_id').make()
if (mgmt.getEdgeLabel('has_artifact') == null) mgmt.makeEdgeLabel('has_artifact').make()

ecosystem = mgmt.makePropertyKey('ecosystem').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
rpm_requirement_name = mgmt.makePropertyKey('rpm_requirement_name').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
version_range = mgmt.makePropertyKey('version_range').dataType(String.class).make()
package_name = mgmt.makePropertyKey('package_name').dataType(String.class).make()
index_url = mgmt.makePropertyKey('index_url').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
extras = mgmt.makePropertyKey('extras').dataType(String.class).make()
artifact_hash_sha256=mgmt.makePropertyKey('artifact_hash_sha256').dataType(String.class).make()
analysis_document_id=mgmt.makePropertyKey('analysis_document_id').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
inspection_document_id=mgmt.makePropertyKey('inspection_document_id').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
run_error=mgmt.makePropertyKey('run_error').dataType(Boolean.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
build_error=mgmt.makePropertyKey('build_error').dataType(Boolean.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
analysis_datetime=mgmt.makePropertyKey('analysis_datetime').dataType(Integer.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
analyzer_name=mgmt.makePropertyKey('analyzer_name').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
analyzer_version=mgmt.makePropertyKey('analyzer_version').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
url=mgmt.makePropertyKey('url').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
warehouse_api_url=mgmt.makePropertyKey('warehouse_api_url').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
verify_ssl=mgmt.makePropertyKey('verify_ssl').dataType(Boolean.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
warehouse=mgmt.makePropertyKey('warehouse').dataType(Boolean.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
package_version =   mgmt.makePropertyKey('package_version').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
solver_document_id=    mgmt.makePropertyKey('solver_document_id').dataType(String.class).make()
solver_name  = mgmt.makePropertyKey('solver_name').dataType(String.class).make()
solver_version =  mgmt.makePropertyKey('solver_version').dataType(String.class).make()
solver_datetime = mgmt.makePropertyKey('solver_datetime').dataType(Integer.class).make()
solver_error   = mgmt.makePropertyKey('solver_error').dataType(Boolean.class).make()
solver_error_unsolvable  = mgmt.makePropertyKey('solver_error_unsolvable').dataType(Boolean.class).make()
solver_error_unparsable  = mgmt.makePropertyKey('solver_error_unparsable').dataType(Boolean.class).make()
runtime_environment_name =  mgmt.makePropertyKey('runtime_environment_name').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
buildtime_environment_name =  mgmt.makePropertyKey('buildtime_environment_name').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
release=   mgmt.makePropertyKey('release').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
epoch =  mgmt.makePropertyKey('epoch').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
arch =  mgmt.makePropertyKey('arch').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
src =  mgmt.makePropertyKey('src').dataType(Boolean.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
package_identifier =  mgmt.makePropertyKey('package_identifier').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
advisory  =mgmt.makePropertyKey('advisory').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
cve_name  = mgmt.makePropertyKey('cve_name').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
cve_id  =  mgmt.makePropertyKey('cve_id').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
document_id  =  mgmt.makePropertyKey('document_id').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
installable = mgmt.makePropertyKey('installable').dataType(Boolean.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
performance_index = mgmt.makePropertyKey('performance_index').dataType(Float.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
cpu_vendor = mgmt.makePropertyKey('cpu_vendor').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
cpu_model_name = mgmt.makePropertyKey('cpu_model_name').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
cpu_model  = mgmt.makePropertyKey('cpu_model').dataType(Integer.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
cpu_family =  mgmt.makePropertyKey('cpu_family').dataType(Integer.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
cpu_cores = mgmt.makePropertyKey('cpu_cores').dataType(Integer.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
gpu_vendor =  mgmt.makePropertyKey('gpu_vendor').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
gpu_model_name = mgmt.makePropertyKey('gpu_model_name').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
gpu_cores= mgmt.makePropertyKey('gpu_cores').dataType(Integer.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
gpu_memory_size=   mgmt.makePropertyKey('gpu_memory_size').dataType(Integer.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
gpu_ram_size= mgmt.makePropertyKey('gpu_ram_size').dataType(Integer.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
software_stack_name = mgmt.makePropertyKey('software_stack_name').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
cpu_physical_cpus = mgmt.makePropertyKey('cpu_physical_cpus').dataType(Integer.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
ram_size = mgmt.makePropertyKey('ram_size').dataType(Integer.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

lbl = mgmt.makePropertyKey('__label__').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
type = mgmt.makePropertyKey('__type__').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

println "Done with Schema creating!"

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
    .addKey(software_stack_name) \
    .buildCompositeIndex()

mgmt.commit()

println "Creating Indicies done!"
