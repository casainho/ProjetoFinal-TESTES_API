package api.retrofit.garage;

import api.calls.ClientCalls;
import api.mappings.garage.Client;
import api.retrofit.RetrofitBuilder;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import retrofit2.Response;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class Clients {
    public static final ClientCalls clientCalls = new RetrofitBuilder().getRetrofit().create(ClientCalls.class);

    // getAllClients
    @SneakyThrows
    public static Response<List<Client>> getAllClients()  {
        return clientCalls.getClients().execute();
    }
}
