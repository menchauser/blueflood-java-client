package karanashev.blueflood.client.endpoints.ingest;

import karanashev.blueflood.client.model.DataPoints;

/**
 * Created by Mukhamed Karanashev on 26.07.2015.
 */
public interface IngestionEndpoint {
    IngestionResult ingest(DataPoints dataPoints);

}
