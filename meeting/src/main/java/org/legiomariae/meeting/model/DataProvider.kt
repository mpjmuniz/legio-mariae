package org.legiomariae.meeting.model

import android.content.Context
import org.legiomariae.meeting.R

data class DataProvider(private val context: Context) {
    val workItems : List<WorkItem> = listOf(WorkItem(context.getString(R.string.ipr_title), context.getString(R.string.ipr_addendum)),
            WorkItem(context.getString(R.string.spr_title), context.getString(R.string.spr_addendum)),
            WorkItem(context.getString(R.string.mnr_title), ""),
            WorkItem(context.getString(R.string.pin_title), context.getString(R.string.pin_addendum)), // TODO: somente 1º do mês
            WorkItem(context.getString(R.string.cal_title), context.getString(R.string.cal_addendum)),
            WorkItem(context.getString(R.string.trr_title), ""),
            WorkItem(context.getString(R.string.wrl_title), context.getString(R.string.wrl_addendum)),
            WorkItem(context.getString(R.string.cat_title), context.getString(R.string.cat_addendum)), // meio tempo da assinatura da ata ao fim da reunião
            WorkItem(context.getString(R.string.alt_title), context.getString(R.string.alt_addendum)),
            WorkItem(context.getString(R.string.scl_title), ""),
            WorkItem(context.getString(R.string.wds_title), context.getString(R.string.wds_addendum)),
            WorkItem(context.getString(R.string.std_title), context.getString(R.string.std_addendum)),
            WorkItem(context.getString(R.string.rcr_title), ""),
            WorkItem(context.getString(R.string.omt_title), context.getString(R.string.omt_addendum)),
            WorkItem(context.getString(R.string.fpr_title), context.getString(R.string.fpr_addendum)),
            WorkItem(context.getString(R.string.fdf_title), ""))
}