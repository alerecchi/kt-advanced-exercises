package delegation.android

import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/*class Activity {

    lateinit var viewModel: MyViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!).get(MyViewModel::class.java)
    }

}*/


/*

class Activity {

    val viewModel by ViewModelDelegate(MyViewModel::class.java)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}

class ViewModelDelegate(javaClass: Class): ReadOnlyProperty<Activity, ViewModel> {

    override fun getValue(thisRef: Activity, property: KProperty<*>): ViewModel {
       return ViewModelProviders.of(activity!!).get(javaClass)
    }
}
*/
