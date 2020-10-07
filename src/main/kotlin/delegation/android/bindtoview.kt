package delegation.android

/*
class MainActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
    }

}
*/
/*

class MainActivity : AppCompatActivity() {

    private val toolBarView by BindToViewDelegate(R.id.toolbar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolBarView
    }


}

class BindToViewDelegate(private val id: Int): ReadOnlyProperty<AppCompatActivity, View> {

    var view: View? = null

    override fun getValue(thisRef: AppCompatActivity, property: KProperty<*>): View {
        if(view == null) {
            view = thisRef.findViewById(id)
        }
        return view!!
    }
}*/
