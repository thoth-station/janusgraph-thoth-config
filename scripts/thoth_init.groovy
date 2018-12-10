:remote connect tinkerpop.server conf/remote-test-2.yaml session
:remote console

import java.util.logging.Logger


Logger logger = Logger.getLogger("")
logger.info("Thoth Schema creationg script v0.1.0")

String[] indexes = [
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

// The Labels we use
String[] vertexLabels = [
    'package',
    'software_stack',
    'python_package_index',
    'python_package_version',
    'rpm_requirement',
    'runtime_environment',
    'deb_package_version',
    'buildtime_environment',
    'rpm_package_version',
    'ecosystem_solver',
    'software_stack_observation',
    'hardware_information',
    'cve',
    'python_artifact',
]
String[] edgeLabels = [
    'has_version',
    'is_part_of',
    'runs_on',
    'runs_in',
    'builds_in',
    'builds_on',
    'depends_on',
    'creates_stack',
    'requires',
    'solved',
    'runs_in',
    'has_vulnerability',
    'deb_replaces',
    'deb_depends',
    'deb_pre_depends',
    'observation_document_id',
    'has_artifact',
]

// The Maps of Labels
Map<String, String> vertexLabel = new HashMap<String, String>();
Map<String, String> edgeLabel = new HashMap<String, String>();

def makeOrCreateVertexLabel(name) {
    label = mgmt.getVertexLabel(name)
    
    if (label == null) {
        label = mgmt.makeVertexLabel(name).make()
    }

    return label
}

def makeOrCreateEdgeLabel(name) {
    label = mgmt.getEdgeLabel(name)
    
    if (label == null) {
        label = mgmt.makeEdgeLabel(name).make()
    }

    return label
}

graph.tx().rollback()

def mgmt = graph.openManagement()

// lets create all our Vertex Labels and store them in a Map
for (label in vertexLabels) {
    vertexLabel.put(label, makeOrCreateVertexLabel(label))
}

// lets create all our Edge Labels and store them in a Map
for (label in edgeLabels) {
    edgeLabel.put(label, makeOrCreateEdgeLabel(label))
}


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
package_version = mgmt.makePropertyKey('package_version').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
solver_document_id = mgmt.makePropertyKey('solver_document_id').dataType(String.class).make()
solver_name = mgmt.makePropertyKey('solver_name').dataType(String.class).make()
solver_version =  mgmt.makePropertyKey('solver_version').dataType(String.class).make()
solver_datetime = mgmt.makePropertyKey('solver_datetime').dataType(Integer.class).make()
solver_error = mgmt.makePropertyKey('solver_error').dataType(Boolean.class).make()
solver_error_unsolvable = mgmt.makePropertyKey('solver_error_unsolvable').dataType(Boolean.class).make()
solver_error_unparsable = mgmt.makePropertyKey('solver_error_unparsable').dataType(Boolean.class).make()
runtime_environment_name =  mgmt.makePropertyKey('runtime_environment_name').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
buildtime_environment_name =  mgmt.makePropertyKey('buildtime_environment_name').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
release = mgmt.makePropertyKey('release').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
epoch = mgmt.makePropertyKey('epoch').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
arch = mgmt.makePropertyKey('arch').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
src = mgmt.makePropertyKey('src').dataType(Boolean.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
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

lbl = mgmt.makePropertyKey('__label__').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()
type = mgmt.makePropertyKey('__type__').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

logger.info("Creating Schema done!")

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

mgmt.commit()

logger.info("Creating Indicies done!")
