// Automatically generated file by Goblinoid.

:remote connect tinkerpop.server conf/remote.yaml session
:remote console


mgmt = graph.openManagement()

adviser_software_stack_vl = mgmt.getVertexLabel('adviser_software_stack')
if (adviser_software_stack_vl == null)
  adviser_software_stack_vl = mgmt.makeVertexLabel('adviser_software_stack').make()

build_observation_vl = mgmt.getVertexLabel('build_observation')
if (build_observation_vl == null)
  build_observation_vl = mgmt.makeVertexLabel('build_observation').make()

buildtime_environment_vl = mgmt.getVertexLabel('buildtime_environment')
if (buildtime_environment_vl == null)
  buildtime_environment_vl = mgmt.makeVertexLabel('buildtime_environment').make()

cve_vl = mgmt.getVertexLabel('cve')
if (cve_vl == null)
  cve_vl = mgmt.makeVertexLabel('cve').make()

deb_package_version_vl = mgmt.getVertexLabel('deb_package_version')
if (deb_package_version_vl == null)
  deb_package_version_vl = mgmt.makeVertexLabel('deb_package_version').make()

ecosystem_solver_vl = mgmt.getVertexLabel('ecosystem_solver')
if (ecosystem_solver_vl == null)
  ecosystem_solver_vl = mgmt.makeVertexLabel('ecosystem_solver').make()

hardware_information_vl = mgmt.getVertexLabel('hardware_information')
if (hardware_information_vl == null)
  hardware_information_vl = mgmt.makeVertexLabel('hardware_information').make()

inspection_software_stack_vl = mgmt.getVertexLabel('inspection_software_stack')
if (inspection_software_stack_vl == null)
  inspection_software_stack_vl = mgmt.makeVertexLabel('inspection_software_stack').make()

package_vl = mgmt.getVertexLabel('package')
if (package_vl == null)
  package_vl = mgmt.makeVertexLabel('package').make()

python_artifact_vl = mgmt.getVertexLabel('python_artifact')
if (python_artifact_vl == null)
  python_artifact_vl = mgmt.makeVertexLabel('python_artifact').make()

python_package_index_vl = mgmt.getVertexLabel('python_package_index')
if (python_package_index_vl == null)
  python_package_index_vl = mgmt.makeVertexLabel('python_package_index').make()

python_package_version_vl = mgmt.getVertexLabel('python_package_version')
if (python_package_version_vl == null)
  python_package_version_vl = mgmt.makeVertexLabel('python_package_version').make()

rpm_package_version_vl = mgmt.getVertexLabel('rpm_package_version')
if (rpm_package_version_vl == null)
  rpm_package_version_vl = mgmt.makeVertexLabel('rpm_package_version').make()

rpm_requirement_vl = mgmt.getVertexLabel('rpm_requirement')
if (rpm_requirement_vl == null)
  rpm_requirement_vl = mgmt.makeVertexLabel('rpm_requirement').make()

runtime_environment_vl = mgmt.getVertexLabel('runtime_environment')
if (runtime_environment_vl == null)
  runtime_environment_vl = mgmt.makeVertexLabel('runtime_environment').make()

software_stack_observation_vl = mgmt.getVertexLabel('software_stack_observation')
if (software_stack_observation_vl == null)
  software_stack_observation_vl = mgmt.makeVertexLabel('software_stack_observation').make()

user_software_stack_vl = mgmt.getVertexLabel('user_software_stack')
if (user_software_stack_vl == null)
  user_software_stack_vl = mgmt.makeVertexLabel('user_software_stack').make()


builds_in_el = mgmt.getEdgeLabel('builds_in')
if (builds_in_el == null)
  builds_in_el = mgmt.makeEdgeLabel('builds_in').make()

builds_on_el = mgmt.getEdgeLabel('builds_on')
if (builds_on_el == null)
  builds_on_el = mgmt.makeEdgeLabel('builds_on').make()

creates_stack_el = mgmt.getEdgeLabel('creates_stack')
if (creates_stack_el == null)
  creates_stack_el = mgmt.makeEdgeLabel('creates_stack').make()

deb_depends_el = mgmt.getEdgeLabel('deb_depends')
if (deb_depends_el == null)
  deb_depends_el = mgmt.makeEdgeLabel('deb_depends').make()

deb_pre_depends_el = mgmt.getEdgeLabel('deb_pre_depends')
if (deb_pre_depends_el == null)
  deb_pre_depends_el = mgmt.makeEdgeLabel('deb_pre_depends').make()

deb_replaces_el = mgmt.getEdgeLabel('deb_replaces')
if (deb_replaces_el == null)
  deb_replaces_el = mgmt.makeEdgeLabel('deb_replaces').make()

depends_on_el = mgmt.getEdgeLabel('depends_on')
if (depends_on_el == null)
  depends_on_el = mgmt.makeEdgeLabel('depends_on').make()

has_artifact_el = mgmt.getEdgeLabel('has_artifact')
if (has_artifact_el == null)
  has_artifact_el = mgmt.makeEdgeLabel('has_artifact').make()

has_version_el = mgmt.getEdgeLabel('has_version')
if (has_version_el == null)
  has_version_el = mgmt.makeEdgeLabel('has_version').make()

has_vulnerability_el = mgmt.getEdgeLabel('has_vulnerability')
if (has_vulnerability_el == null)
  has_vulnerability_el = mgmt.makeEdgeLabel('has_vulnerability').make()

is_part_of_el = mgmt.getEdgeLabel('is_part_of')
if (is_part_of_el == null)
  is_part_of_el = mgmt.makeEdgeLabel('is_part_of').make()

observed_el = mgmt.getEdgeLabel('observed')
if (observed_el == null)
  observed_el = mgmt.makeEdgeLabel('observed').make()

requires_el = mgmt.getEdgeLabel('requires')
if (requires_el == null)
  requires_el = mgmt.makeEdgeLabel('requires').make()

runs_in_el = mgmt.getEdgeLabel('runs_in')
if (runs_in_el == null)
  runs_in_el = mgmt.makeEdgeLabel('runs_in').make()

runs_on_el = mgmt.getEdgeLabel('runs_on')
if (runs_on_el == null)
  runs_on_el = mgmt.makeEdgeLabel('runs_on').make()

solved_el = mgmt.getEdgeLabel('solved')
if (solved_el == null)
  solved_el = mgmt.makeEdgeLabel('solved').make()


adviser_error_p = mgmt.getPropertyKey('adviser_error')
if (adviser_error_p == null)
  adviser_error_p = mgmt.makePropertyKey('adviser_error').dataType(Boolean.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

adviser_stack_index_p = mgmt.getPropertyKey('adviser_stack_index')
if (adviser_stack_index_p == null)
  adviser_stack_index_p = mgmt.makePropertyKey('adviser_stack_index').dataType(Integer.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

advisory_p = mgmt.getPropertyKey('advisory')
if (advisory_p == null)
  advisory_p = mgmt.makePropertyKey('advisory').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

analysis_datetime_p = mgmt.getPropertyKey('analysis_datetime')
if (analysis_datetime_p == null)
  analysis_datetime_p = mgmt.makePropertyKey('analysis_datetime').dataType(Integer.class).make()

analysis_document_id_p = mgmt.getPropertyKey('analysis_document_id')
if (analysis_document_id_p == null)
  analysis_document_id_p = mgmt.makePropertyKey('analysis_document_id').dataType(String.class).make()

analyzer_name_p = mgmt.getPropertyKey('analyzer_name')
if (analyzer_name_p == null)
  analyzer_name_p = mgmt.makePropertyKey('analyzer_name').dataType(String.class).make()

analyzer_version_p = mgmt.getPropertyKey('analyzer_version')
if (analyzer_version_p == null)
  analyzer_version_p = mgmt.makePropertyKey('analyzer_version').dataType(String.class).make()

arch_p = mgmt.getPropertyKey('arch')
if (arch_p == null)
  arch_p = mgmt.makePropertyKey('arch').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

artifact_hash_sha256_p = mgmt.getPropertyKey('artifact_hash_sha256')
if (artifact_hash_sha256_p == null)
  artifact_hash_sha256_p = mgmt.makePropertyKey('artifact_hash_sha256').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

build_error_p = mgmt.getPropertyKey('build_error')
if (build_error_p == null)
  build_error_p = mgmt.makePropertyKey('build_error').dataType(Boolean.class).make()

buildtime_environment_name_p = mgmt.getPropertyKey('buildtime_environment_name')
if (buildtime_environment_name_p == null)
  buildtime_environment_name_p = mgmt.makePropertyKey('buildtime_environment_name').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

cpu_cores_p = mgmt.getPropertyKey('cpu_cores')
if (cpu_cores_p == null)
  cpu_cores_p = mgmt.makePropertyKey('cpu_cores').dataType(Integer.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

cpu_family_p = mgmt.getPropertyKey('cpu_family')
if (cpu_family_p == null)
  cpu_family_p = mgmt.makePropertyKey('cpu_family').dataType(Integer.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

cpu_model_p = mgmt.getPropertyKey('cpu_model')
if (cpu_model_p == null)
  cpu_model_p = mgmt.makePropertyKey('cpu_model').dataType(Integer.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

cpu_model_name_p = mgmt.getPropertyKey('cpu_model_name')
if (cpu_model_name_p == null)
  cpu_model_name_p = mgmt.makePropertyKey('cpu_model_name').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

cpu_physical_cpus_p = mgmt.getPropertyKey('cpu_physical_cpus')
if (cpu_physical_cpus_p == null)
  cpu_physical_cpus_p = mgmt.makePropertyKey('cpu_physical_cpus').dataType(Integer.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

cuda_version_p = mgmt.getPropertyKey('cuda_version')
if (cuda_version_p == null)
  cuda_version_p = mgmt.makePropertyKey('cuda_version').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

cve_id_p = mgmt.getPropertyKey('cve_id')
if (cve_id_p == null)
  cve_id_p = mgmt.makePropertyKey('cve_id').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

cve_name_p = mgmt.getPropertyKey('cve_name')
if (cve_name_p == null)
  cve_name_p = mgmt.makePropertyKey('cve_name').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

document_id_p = mgmt.getPropertyKey('document_id')
if (document_id_p == null)
  document_id_p = mgmt.makePropertyKey('document_id').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

ecosystem_p = mgmt.getPropertyKey('ecosystem')
if (ecosystem_p == null)
  ecosystem_p = mgmt.makePropertyKey('ecosystem').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

epoch_p = mgmt.getPropertyKey('epoch')
if (epoch_p == null)
  epoch_p = mgmt.makePropertyKey('epoch').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

extras_p = mgmt.getPropertyKey('extras')
if (extras_p == null)
  extras_p = mgmt.makePropertyKey('extras').dataType(String.class).make()

index_url_p = mgmt.getPropertyKey('index_url')
if (index_url_p == null)
  index_url_p = mgmt.makePropertyKey('index_url').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

inspection_document_id_p = mgmt.getPropertyKey('inspection_document_id')
if (inspection_document_id_p == null)
  inspection_document_id_p = mgmt.makePropertyKey('inspection_document_id').dataType(String.class).make()

origin_p = mgmt.getPropertyKey('origin')
if (origin_p == null)
  origin_p = mgmt.makePropertyKey('origin').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

os_name_p = mgmt.getPropertyKey('os_name')
if (os_name_p == null)
  os_name_p = mgmt.makePropertyKey('os_name').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

os_version_p = mgmt.getPropertyKey('os_version')
if (os_version_p == null)
  os_version_p = mgmt.makePropertyKey('os_version').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

package_identifier_p = mgmt.getPropertyKey('package_identifier')
if (package_identifier_p == null)
  package_identifier_p = mgmt.makePropertyKey('package_identifier').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

package_name_p = mgmt.getPropertyKey('package_name')
if (package_name_p == null)
  package_name_p = mgmt.makePropertyKey('package_name').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

package_version_p = mgmt.getPropertyKey('package_version')
if (package_version_p == null)
  package_version_p = mgmt.makePropertyKey('package_version').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

performance_index_p = mgmt.getPropertyKey('performance_index')
if (performance_index_p == null)
  performance_index_p = mgmt.makePropertyKey('performance_index').dataType(Float.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

python_version_p = mgmt.getPropertyKey('python_version')
if (python_version_p == null)
  python_version_p = mgmt.makePropertyKey('python_version').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

ram_size_p = mgmt.getPropertyKey('ram_size')
if (ram_size_p == null)
  ram_size_p = mgmt.makePropertyKey('ram_size').dataType(Float.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

release_p = mgmt.getPropertyKey('release')
if (release_p == null)
  release_p = mgmt.makePropertyKey('release').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

rpm_requirement_name_p = mgmt.getPropertyKey('rpm_requirement_name')
if (rpm_requirement_name_p == null)
  rpm_requirement_name_p = mgmt.makePropertyKey('rpm_requirement_name').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

run_error_p = mgmt.getPropertyKey('run_error')
if (run_error_p == null)
  run_error_p = mgmt.makePropertyKey('run_error').dataType(Boolean.class).make()

runtime_environment_name_p = mgmt.getPropertyKey('runtime_environment_name')
if (runtime_environment_name_p == null)
  runtime_environment_name_p = mgmt.makePropertyKey('runtime_environment_name').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

solver_datetime_p = mgmt.getPropertyKey('solver_datetime')
if (solver_datetime_p == null)
  solver_datetime_p = mgmt.makePropertyKey('solver_datetime').dataType(Integer.class).make()

solver_document_id_p = mgmt.getPropertyKey('solver_document_id')
if (solver_document_id_p == null)
  solver_document_id_p = mgmt.makePropertyKey('solver_document_id').dataType(String.class).make()

solver_error_p = mgmt.getPropertyKey('solver_error')
if (solver_error_p == null)
  solver_error_p = mgmt.makePropertyKey('solver_error').dataType(Boolean.class).make()

solver_error_unparsable_p = mgmt.getPropertyKey('solver_error_unparsable')
if (solver_error_unparsable_p == null)
  solver_error_unparsable_p = mgmt.makePropertyKey('solver_error_unparsable').dataType(Boolean.class).make()

solver_error_unsolvable_p = mgmt.getPropertyKey('solver_error_unsolvable')
if (solver_error_unsolvable_p == null)
  solver_error_unsolvable_p = mgmt.makePropertyKey('solver_error_unsolvable').dataType(Boolean.class).make()

solver_name_p = mgmt.getPropertyKey('solver_name')
if (solver_name_p == null)
  solver_name_p = mgmt.makePropertyKey('solver_name').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

solver_version_p = mgmt.getPropertyKey('solver_version')
if (solver_version_p == null)
  solver_version_p = mgmt.makePropertyKey('solver_version').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

src_p = mgmt.getPropertyKey('src')
if (src_p == null)
  src_p = mgmt.makePropertyKey('src').dataType(Boolean.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

url_p = mgmt.getPropertyKey('url')
if (url_p == null)
  url_p = mgmt.makePropertyKey('url').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

verify_ssl_p = mgmt.getPropertyKey('verify_ssl')
if (verify_ssl_p == null)
  verify_ssl_p = mgmt.makePropertyKey('verify_ssl').dataType(Boolean.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

version_range_p = mgmt.getPropertyKey('version_range')
if (version_range_p == null)
  version_range_p = mgmt.makePropertyKey('version_range').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

warehouse_api_url_p = mgmt.getPropertyKey('warehouse_api_url')
if (warehouse_api_url_p == null)
  warehouse_api_url_p = mgmt.makePropertyKey('warehouse_api_url').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

lbl = mgmt.getPropertyKey('__label__')
if (lbl == null)
  lbl = mgmt.makePropertyKey('__label__').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

type = mgmt.getPropertyKey('__type__')
if (type == null)
  type = mgmt.makePropertyKey('__type__').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

//
// Indexes defined for the schema.
//

mgmt.buildIndex('byEdge', org.apache.tinkerpop.gremlin.structure.Edge.class) \
   .addKey(lbl) \
   .addKey(type) \
   .buildCompositeIndex()

mgmt.buildIndex('byPackage', org.apache.tinkerpop.gremlin.structure.Vertex.class) \
   .addKey(lbl) \
   .addKey(type) \
   .addKey(ecosystem_p) \
   .addKey(package_name_p) \
   .buildCompositeIndex()

mgmt.buildIndex('byPythonPackageVersion', org.apache.tinkerpop.gremlin.structure.Vertex.class) \
   .addKey(lbl) \
   .addKey(type) \
   .addKey(ecosystem_p) \
   .addKey(package_name_p) \
   .addKey(package_version_p) \
   .addKey(index_url_p) \
   .indexOnly(python_package_version_vl) \
   .buildCompositeIndex()

mgmt.buildIndex('byPythonPackageVersionNoIndex', org.apache.tinkerpop.gremlin.structure.Vertex.class) \
   .addKey(lbl) \
   .addKey(ecosystem_p) \
   .addKey(package_name_p) \
   .addKey(package_version_p) \
   .buildCompositeIndex()

mgmt.buildIndex('byPythonPackageIndex', org.apache.tinkerpop.gremlin.structure.Vertex.class) \
   .addKey(lbl) \
   .addKey(type) \
   .addKey(url_p) \
   .addKey(warehouse_api_url_p) \
   .addKey(verify_ssl_p) \
   .addKey(warehouse_api_url_p) \
   .buildCompositeIndex()

mgmt.buildIndex('byPythonArtifact', org.apache.tinkerpop.gremlin.structure.Vertex.class) \
   .addKey(lbl) \
   .addKey(type) \
   .addKey(artifact_hash_sha256_p) \
   .buildCompositeIndex()

mgmt.buildIndex('byIsPartOf', org.apache.tinkerpop.gremlin.structure.Edge.class) \
   .addKey(lbl) \
   .addKey(type) \
   .addKey(analysis_datetime_p) \
   .addKey(analysis_document_id_p) \
   .addKey(analyzer_name_p) \
   .addKey(analyzer_version_p) \
   .buildCompositeIndex()

mgmt.buildIndex('byDependsOn', org.apache.tinkerpop.gremlin.structure.Edge.class) \
   .addKey(lbl) \
   .addKey(type) \
   .addKey(version_range_p) \
   .addKey(package_name_p) \
   .addKey(extras_p) \
   .buildCompositeIndex()

mgmt.buildIndex('byCVE', org.apache.tinkerpop.gremlin.structure.Vertex.class) \
   .addKey(lbl) \
   .addKey(type) \
   .addKey(version_range_p) \
   .addKey(advisory_p) \
   .addKey(cve_name_p) \
   .addKey(cve_id_p) \
   .buildCompositeIndex()

mgmt.buildIndex('bySolved', org.apache.tinkerpop.gremlin.structure.Edge.class) \
   .addKey(lbl) \
   .addKey(type) \
   .addKey(solver_datetime_p) \
   .addKey(solver_document_id_p) \
   .addKey(solver_error_p) \
   .addKey(solver_error_unsolvable_p) \
   .addKey(solver_error_unparsable_p) \
   .buildCompositeIndex()

mgmt.buildIndex('byRequires', org.apache.tinkerpop.gremlin.structure.Edge.class) \
   .addKey(lbl) \
   .addKey(type) \
   .addKey(analysis_datetime_p) \
   .addKey(analysis_document_id_p) \
   .addKey(analyzer_name_p) \
   .addKey(analyzer_version_p) \
   .buildCompositeIndex()

mgmt.buildIndex('byRuntimeEnvironment', org.apache.tinkerpop.gremlin.structure.Vertex.class) \
   .addKey(lbl) \
   .addKey(type) \
   .addKey(runtime_environment_name_p) \
   .buildCompositeIndex()

mgmt.buildIndex('byBuildtimeEnvironment', org.apache.tinkerpop.gremlin.structure.Vertex.class) \
   .addKey(lbl) \
   .addKey(type) \
   .addKey(buildtime_environment_name_p) \
   .buildCompositeIndex()

mgmt.buildIndex('byRPMRequirement', org.apache.tinkerpop.gremlin.structure.Vertex.class) \
   .addKey(lbl) \
   .addKey(type) \
   .addKey(rpm_requirement_name_p) \
   .buildCompositeIndex()

mgmt.buildIndex('byRPMPackageVersion', org.apache.tinkerpop.gremlin.structure.Vertex.class) \
   .addKey(lbl) \
   .addKey(type) \
   .addKey(ecosystem_p) \
   .addKey(package_name_p) \
   .addKey(package_version_p) \
   .addKey(release_p) \
   .addKey(epoch_p) \
   .addKey(arch_p) \
   .addKey(src_p) \
   .addKey(package_identifier_p) \
   .buildCompositeIndex()

mgmt.buildIndex('byEcosystemSolver', org.apache.tinkerpop.gremlin.structure.Vertex.class) \
   .addKey(lbl) \
   .addKey(type) \
   .addKey(solver_name_p) \
   .addKey(solver_version_p) \
   .buildCompositeIndex()

mgmt.buildIndex('byDebPackageVersion', org.apache.tinkerpop.gremlin.structure.Vertex.class) \
   .addKey(lbl) \
   .addKey(type) \
   .addKey(ecosystem_p) \
   .addKey(package_name_p) \
   .addKey(package_version_p) \
   .addKey(epoch_p) \
   .addKey(arch_p) \
   .buildCompositeIndex()

mgmt.buildIndex('byDocumentId', org.apache.tinkerpop.gremlin.structure.Vertex.class) \
   .addKey(lbl) \
   .addKey(type) \
   .addKey(document_id_p) \
   .buildCompositeIndex()

mgmt.buildIndex('byHardwareInformation', org.apache.tinkerpop.gremlin.structure.Vertex.class) \
   .addKey(lbl) \
   .addKey(type) \
   .addKey(cpu_model_name_p) \
   .addKey(cpu_model_p) \
   .addKey(cpu_family_p) \
   .addKey(cpu_cores_p) \
   .addKey(cpu_physical_cpus_p) \
   .addKey(ram_size_p) \
   .buildCompositeIndex()

mgmt.commit()
