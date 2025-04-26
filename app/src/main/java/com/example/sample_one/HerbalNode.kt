data class HerbalNode(
    var x: Float,
    var y: Float,
    val label: String,
    val neighbors: MutableList<HerbalNode> = mutableListOf(),
    var isExpanded: Boolean = false
)
