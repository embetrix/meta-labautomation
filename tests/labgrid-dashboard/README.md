The nginx proxy integration is enabled when `meta-raspberrypi-secure` is
present and extends its existing HTTPS site. Other controller builds need
their own HTTPS proxy configuration for the dashboard.

Run the nginx installation checks locally:

```sh
python3 tests/labgrid-dashboard/test_nginx.py
```

After building the API image with the layer's Compose configuration, run the
access regression checks in an isolated disposable container:

```sh
docker run --rm --network none --entrypoint python \
  -v "$PWD/tests/labgrid-dashboard/test_access.py:/app/test_access.py:ro" \
  labautomation/labgrid-dashboard-api:e1088e62-3 /app/test_access.py
```

The test starts a temporary coordinator and simulated serial server inside the
container. It checks resource ownership, wildcard/renamed resources and console
cleanup across user acquisitions. No controller or physical DUT is contacted.
