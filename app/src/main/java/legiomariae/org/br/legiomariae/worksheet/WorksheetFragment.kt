package legiomariae.org.br.legiomariae.worksheet

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_worksheet.*
import legiomariae.org.br.legiomariae.R
import legiomariae.org.br.legiomariae.model.DataProvider
import legiomariae.org.br.legiomariae.model.WorkItem

class WorksheetFragment:Fragment() {

    /*
    * Layout code, no need to test
    * */
    override fun onCreateView(inflater:LayoutInflater, container:ViewGroup?,
        savedInstanceState:Bundle?):View? {
        return inflater.inflate(R.layout.fragment_worksheet, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvWorkItems.adapter = WorkItemAdapter(activity, DataProvider(activity).workItems)
        rvWorkItems.layoutManager = LinearLayoutManager(activity)
        rvWorkItems.setHasFixedSize(true)
    }

    private data class WorkItemAdapter(val context : Context, val workItems : List<WorkItem>)
        : RecyclerView.Adapter<WorkItemAdapter.Holder>(){

        override fun getItemCount(): Int {
            return workItems.count()
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            try {
                holder.bindWorkItem(workItems[position])
            } catch (e: Exception){}
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
            val view = LayoutInflater.from(context)
                                    .inflate(R.layout.work_item, parent, false)

            return Holder(view!!)
        }

        private inner class Holder(val itemV: View,
                                   val itemTitle: TextView = itemV.findViewById(R.id.workItemTitle))
            : RecyclerView.ViewHolder(itemV){

            fun bindWorkItem(workItem : WorkItem){
                itemTitle.text = workItem.toString()
            }
        }
    }
}