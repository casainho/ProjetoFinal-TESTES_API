package api.retrofit.garage;

import api.calls.ClientCalls;
import api.mappings.garage.Client;
import api.mappings.garage.ClientWithVehicles;
import api.retrofit.RetrofitBuilder;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import retrofit2.Response;

import java.util.List;

public class Clients {
    public ClientCalls clientCalls = new RetrofitBuilder().getRetrofit().create(ClientCalls.class);

    // getAllClients
    @SneakyThrows
    public Response<List<ClientWithVehicles>> getAllClientsWithVehicles()  {
        return clientCalls.getClients().execute();
    }

    // postClient
    @SneakyThrows
    public Response<Integer> createClient(Client client)  {
        return clientCalls.createClient(client).execute();
    }

    // deleteClient
    @SneakyThrows
    public Response<ResponseBody> deleteClient(int id)  {
        return clientCalls.deleteClient(id).execute();
    }
}
