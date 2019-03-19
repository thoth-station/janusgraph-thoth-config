Thoth's additions to JanusGraph
-------------------------------

The content of this directory should land at `/opt/janusgraph-0.3.1-hadoop2/`,
it contains the Thoth specific configuration of JanusGraph.

Running JanusGraph instance locally
===================================

First, make sure you have buildah and podman installed:

.. code-block:: console

  dnf install -y podman buildah

Note, currently all the commands have to be run as root (prepend "``sudo``).

You can run JanusGraph locally on your workmachine if you would like to
experiment with schema, graph queries or graph-related stuff in Thoth. To do
so, you need to first build a JanusGraph container. There is provided a handy
utility ``local.sh`` which helps you to manage a local JanusGraph instance.

.. code-block:: console

  ./local.sh build

The command above will produce a container image with JanusGraph without any
schema and indexes being created. To initialize JanusGraph with schema and
indexes, run the following command after the ``build`` command:

.. code-block:: console

  ./local.sh init

With this command you will have an initialized local JanusGraph instance which
you can run using the ``run`` command:

.. code-block:: console

  ./local.sh run


During the ``init`` command, there is used schema and indexes from the local
Git repository so if you make any changes to them, they will be propagated to
the built JanusGraph instance (handy for local tests and development). If you
would like to rebuild the container with new changes made to the schema, you
can simply do by repeating the ``init`` command (note the un-initialized
JanusGraph instance is kept untouched).

To simply run all of the above to have a coffee meanwhile, just run:

.. code-block:: console

  ./local.sh all

To clean your local development environment, just run:

.. code-block:: console

  ./local.sh clean

See the following command for more help:

.. code-block:: console

  ./local.sh help


The commands discussed above will run the JanusGraph on your machine, which
will be accessible on 8182 port (default for JanusGraph). To interact with this
instance, you can export `JANUSGRAPH_SERVICE_HOST=localhost` and all the
libraries and CLIs in Thoth will automatically talk to this instance. See
`Thoth's Developer Guide
<https://github.com/thoth-station/thoth/blob/master/docs/developers_guide.rst#developers-guide-to-thoth>`_
for more info.

Connecting to a remote instance using Gremlin shell
===================================================

First, download JanusGraph release which provides gremlin shell:

.. code-block::

  ./local.sh download

Adjust entry in `hosts` so that it points to an instance you would like to talk to:

.. code-block:: console

  vim janusgraph-*-hadoop2/conf/remote.yaml
  # Adjust "hosts", e.g. from:
  #   hosts: [localhost]
  # to:
  #   hosts: [janusgraph.test.thoth-station.ninja]

Run Gremlin shell:

.. code-block:: console

  ./janusgraph-0.3.1-hadoop2/bin/gremlin.sh

And execute following commands to connect to a remote instance:

.. code-block:: console

  :remote connect tinkerpop.server conf/remote.yaml session
  :remote console

To profile a query:

.. code-block:: console

  g.V().count().profile()


Troubleshooting local instance
==============================

Q: I'm getting an error message that the JanusGraph instance has too many files opened.

Place the following configuration into your `/etc/security/limits.conf`:

.. code-block::

  * soft nofile 4096
  * hard nofile 4096

And verify the new configuration is applied:

.. code-block:: console

  $  ulimit -Sn