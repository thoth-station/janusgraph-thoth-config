:remote connect tinkerpop.server conf/remote.yaml session
:remote console

mgmt = graph.openManagement()

if (mgmt.getVertexLabel('adviser_software_stack') == null)
  mgmt.makeVertexLabel('adviser_software_stack').make()
if (mgmt.getVertexLabel('build_observation') == null)
  mgmt.makeVertexLabel('build_observation').make()
if (mgmt.getVertexLabel('buildtime_environment') == null)
  mgmt.makeVertexLabel('buildtime_environment').make()
if (mgmt.getVertexLabel('cve') == null)
  mgmt.makeVertexLabel('cve').make()
if (mgmt.getVertexLabel('deb_package_version') == null)
  mgmt.makeVertexLabel('deb_package_version').make()
if (mgmt.getVertexLabel('ecosystem_solver') == null)
  mgmt.makeVertexLabel('ecosystem_solver').make()
if (mgmt.getVertexLabel('hardware_information') == null)
  mgmt.makeVertexLabel('hardware_information').make()
if (mgmt.getVertexLabel('inspection_software_stack') == null)
  mgmt.makeVertexLabel('inspection_software_stack').make()
if (mgmt.getVertexLabel('package') == null)
  mgmt.makeVertexLabel('package').make()
if (mgmt.getVertexLabel('python_artifact') == null)
  mgmt.makeVertexLabel('python_artifact').make()
if (mgmt.getVertexLabel('python_package_index') == null)
  mgmt.makeVertexLabel('python_package_index').make()
if (mgmt.getVertexLabel('python_package_version') == null)
  mgmt.makeVertexLabel('python_package_version').make()
if (mgmt.getVertexLabel('rpm_package_version') == null)
  mgmt.makeVertexLabel('rpm_package_version').make()
if (mgmt.getVertexLabel('rpm_requirement') == null)
  mgmt.makeVertexLabel('rpm_requirement').make()
if (mgmt.getVertexLabel('runtime_environment') == null)
  mgmt.makeVertexLabel('runtime_environment').make()
if (mgmt.getVertexLabel('software_stack_observation') == null)
  mgmt.makeVertexLabel('software_stack_observation').make()
if (mgmt.getVertexLabel('user_software_stack') == null)
  mgmt.makeVertexLabel('user_software_stack').make()

if (mgmt.getEdgeLabel('builds_in') == null)
  mgmt.makeEdgeLabel('builds_in').make()
if (mgmt.getEdgeLabel('builds_on') == null)
  mgmt.makeEdgeLabel('builds_on').make()
if (mgmt.getEdgeLabel('creates_stack') == null)
  mgmt.makeEdgeLabel('creates_stack').make()
if (mgmt.getEdgeLabel('deb_depends') == null)
  mgmt.makeEdgeLabel('deb_depends').make()
if (mgmt.getEdgeLabel('deb_pre_depends') == null)
  mgmt.makeEdgeLabel('deb_pre_depends').make()
if (mgmt.getEdgeLabel('deb_replaces') == null)
  mgmt.makeEdgeLabel('deb_replaces').make()
if (mgmt.getEdgeLabel('depends_on') == null)
  mgmt.makeEdgeLabel('depends_on').make()
if (mgmt.getEdgeLabel('has_version') == null)
  mgmt.makeEdgeLabel('has_version').make()
if (mgmt.getEdgeLabel('has_vulnerability') == null)
  mgmt.makeEdgeLabel('has_vulnerability').make()
if (mgmt.getEdgeLabel('is_part_of') == null)
  mgmt.makeEdgeLabel('is_part_of').make()
if (mgmt.getEdgeLabel('observed') == null)
  mgmt.makeEdgeLabel('observed').make()
if (mgmt.getEdgeLabel('requires') == null)
  mgmt.makeEdgeLabel('requires').make()
if (mgmt.getEdgeLabel('runs_in') == null)
  mgmt.makeEdgeLabel('runs_in').make()
if (mgmt.getEdgeLabel('runs_on') == null)
  mgmt.makeEdgeLabel('runs_on').make()
if (mgmt.getEdgeLabel('solved') == null)
  mgmt.makeEdgeLabel('solved').make()

if (mgmt.getPropertyKey('adviser_error') == null)
  mgmt.makePropertyKey('adviser_error').dataType(Boolean.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('adviser_stack_index') == null)
  mgmt.makePropertyKey('adviser_stack_index').dataType(Integer.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('advisory') == null)
  mgmt.makePropertyKey('advisory').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('analysis_datetime') == null)
  mgmt.makePropertyKey('analysis_datetime').dataType(Integer.class).make()

if (mgmt.getPropertyKey('analysis_document_id') == null)
  mgmt.makePropertyKey('analysis_document_id').dataType(String.class).make()

if (mgmt.getPropertyKey('analyzer_name') == null)
  mgmt.makePropertyKey('analyzer_name').dataType(String.class).make()

if (mgmt.getPropertyKey('analyzer_version') == null)
  mgmt.makePropertyKey('analyzer_version').dataType(String.class).make()

if (mgmt.getPropertyKey('arch') == null)
  mgmt.makePropertyKey('arch').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('artifact_hash_sha256') == null)
  mgmt.makePropertyKey('artifact_hash_sha256').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('build_error') == null)
  mgmt.makePropertyKey('build_error').dataType(Boolean.class).make()

if (mgmt.getPropertyKey('buildtime_environment_name') == null)
  mgmt.makePropertyKey('buildtime_environment_name').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('cpu_cores') == null)
  mgmt.makePropertyKey('cpu_cores').dataType(Integer.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('cpu_family') == null)
  mgmt.makePropertyKey('cpu_family').dataType(Integer.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('cpu_model') == null)
  mgmt.makePropertyKey('cpu_model').dataType(Integer.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('cpu_model_name') == null)
  mgmt.makePropertyKey('cpu_model_name').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('cpu_physical_cpus') == null)
  mgmt.makePropertyKey('cpu_physical_cpus').dataType(Integer.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('cuda_version') == null)
  mgmt.makePropertyKey('cuda_version').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('cve_id') == null)
  mgmt.makePropertyKey('cve_id').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('cve_name') == null)
  mgmt.makePropertyKey('cve_name').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('document_id') == null)
  mgmt.makePropertyKey('document_id').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('ecosystem') == null)
  mgmt.makePropertyKey('ecosystem').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('epoch') == null)
  mgmt.makePropertyKey('epoch').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('extras') == null)
  mgmt.makePropertyKey('extras').dataType(String.class).make()

if (mgmt.getPropertyKey('index_url') == null)
  mgmt.makePropertyKey('index_url').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('inspection_document_id') == null)
  mgmt.makePropertyKey('inspection_document_id').dataType(String.class).make()

if (mgmt.getPropertyKey('origin') == null)
  mgmt.makePropertyKey('origin').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('os_name') == null)
  mgmt.makePropertyKey('os_name').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('os_version') == null)
  mgmt.makePropertyKey('os_version').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('package_identifier') == null)
  mgmt.makePropertyKey('package_identifier').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('package_name') == null)
  mgmt.makePropertyKey('package_name').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('package_version') == null)
  mgmt.makePropertyKey('package_version').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('performance_index') == null)
  mgmt.makePropertyKey('performance_index').dataType(Float.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('python_version') == null)
  mgmt.makePropertyKey('python_version').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('ram_size') == null)
  mgmt.makePropertyKey('ram_size').dataType(Integer.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('release') == null)
  mgmt.makePropertyKey('release').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('rpm_requirement_name') == null)
  mgmt.makePropertyKey('rpm_requirement_name').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('run_error') == null)
  mgmt.makePropertyKey('run_error').dataType(Boolean.class).make()

if (mgmt.getPropertyKey('runtime_environment_name') == null)
  mgmt.makePropertyKey('runtime_environment_name').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('solver_datetime') == null)
  mgmt.makePropertyKey('solver_datetime').dataType(Integer.class).make()

if (mgmt.getPropertyKey('solver_document_id') == null)
  mgmt.makePropertyKey('solver_document_id').dataType(String.class).make()

if (mgmt.getPropertyKey('solver_error') == null)
  mgmt.makePropertyKey('solver_error').dataType(Boolean.class).make()

if (mgmt.getPropertyKey('solver_error_unparsable') == null)
  mgmt.makePropertyKey('solver_error_unparsable').dataType(Boolean.class).make()

if (mgmt.getPropertyKey('solver_error_unsolvable') == null)
  mgmt.makePropertyKey('solver_error_unsolvable').dataType(Boolean.class).make()

if (mgmt.getPropertyKey('solver_name') == null)
  mgmt.makePropertyKey('solver_name').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('solver_version') == null)
  mgmt.makePropertyKey('solver_version').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('src') == null)
  mgmt.makePropertyKey('src').dataType(Boolean.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('url') == null)
  mgmt.makePropertyKey('url').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('verify_ssl') == null)
  mgmt.makePropertyKey('verify_ssl').dataType(Boolean.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('version_range') == null)
  mgmt.makePropertyKey('version_range').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('warehouse_api_url') == null)
  mgmt.makePropertyKey('warehouse_api_url').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('__label__') == null)
  mgmt.makePropertyKey('__label__').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()

if (mgmt.getPropertyKey('__type__') == null)
  mgmt.makePropertyKey('__type__').dataType(String.class).cardinality(org.janusgraph.core.Cardinality.SINGLE).make()


mgmt.commit()
