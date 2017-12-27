package org.legiomariae.meeting.model


data class WorkItem(val title : String, val addendum : String){
    override fun toString(): String {
        return "$title $addendum"
    }

    override fun equals(other: Any?): Boolean {
        return this.title == other.toString()
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + addendum.hashCode()
        return result
    }
}