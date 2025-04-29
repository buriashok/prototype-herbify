import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Plant(
    val name: String,
    val imageResId: Int
) : Parcelable
