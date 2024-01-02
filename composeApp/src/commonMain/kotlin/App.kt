import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun App() = MaterialTheme {

    val category = remember { mutableStateOf("") }
    val subcategory = remember { mutableStateOf("") }
    var amount by remember { mutableLongStateOf(0L) }
    var description by remember { mutableStateOf("") }

    // Map of categories to their subcategories
    val categories = mapOf(
        "Transport" to listOf("Fuel", "Public Transit", "Maintenance"),
        "Groceries" to listOf("Food", "Household Items"),
        "Entertainment" to listOf("Movies", "Concerts", "Games"),
    )

    Column {

        Spacer(modifier = Modifier.height(200.dp))

        DropDownField(
            state = category,
            label = "Category",
            items = categories.keys.toList(),
            onValueChange = {
                category.value = it
            })

        categories[category.value]?.toList()?.let {
            DropDownField(
                state = subcategory,
                label = "Sub-Category",
                items = it,
                onValueChange = {
                    subcategory.value = it
                })
        }
    }

}