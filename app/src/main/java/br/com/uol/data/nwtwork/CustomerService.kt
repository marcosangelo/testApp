
import br.com.uol.domain.ResponseCustomer
import retrofit2.http.GET

interface CustomerService {

    @GET("service.json")
    suspend fun getCustomers(): ResponseCustomer
}