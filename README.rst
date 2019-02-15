Thoth's additions to JanusGraph
-------------------------------

The content of this directory should land at `/opt/janusgraph-0.3.1-hadoop2/`,
it contains the Thoth specific configuration of JanusGraph.

Running JanusGraph instance locally
===================================

You can run JanusGraph locally on your workmachine if you would like to
experiment with schema, graph queries or graph-related stuff in Thoth. To do
so, you need to first build JanusGraph container:

.. code-bloack:: console

  # In the root of this git repository:
  dnf install -y podman buildah # also consider skopeo
  ./build-local.sh

The command above will produce a container image (note we do not use Docker!):

.. code-block:: console

    podman images
    REPOSITORY                                   TAG      IMAGE ID       CREATED          SIZE
    localhost/thoth-janusgraph                   latest   0a515fb2862d   8 minutes ago    1.6 GB

And we can now run the built image using:

.. code-bloack:: console

  ./run-local.sh

The command above will run the JanusGraph on your machine, wich will be
accessible on 8182 port (default for JanusGraph). To interact with this
instance, you can export `JANUSGRAPH_SERVICE_HOST=localhost` and all the
libraries and CLIs in Thoth will automatically talk to this instance. See
`Thoth's Developer Guide
<https://github.com/thoth-station/thoth/blob/master/docs/developers_guide.rst#developers-guide-to-thoth>`_
for more info.

