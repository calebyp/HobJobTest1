package comp433.calebpipkin.hobjobtest1;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    DatabaseHelper mDatabaseHelper;
    private Button btnAdd, btnViewData;
    private EditText typeTV, contactTV, eventTV, descriptionTV, imageTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        typeTV = (EditText) findViewById(R.id.typeTv);
        contactTV = (EditText) findViewById(R.id.contact);
        eventTV = (EditText) findViewById(R.id.event);
        descriptionTV = (EditText) findViewById(R.id.descript);
        imageTV = (EditText) findViewById(R.id.imageres);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnViewData = (Button) findViewById(R.id.btnView);
        mDatabaseHelper = new DatabaseHelper(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = typeTV.getText().toString();
                String contact = contactTV.getText().toString();
                String event = eventTV.getText().toString();
                String description = descriptionTV.getText().toString();
                String image = imageTV.getText().toString();
                if (type.length() != 0 && contact.length() !=0 && event.length() != 0 && description.length() != 0 && image.length() != 0) {
                    AddData(type, contact, event, description, image);

                } else {
                    toastMessage("You must put something in all fields!");
                }

            }
        });

        btnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListDataActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

    }

    public void AddData(String type, String contact, String event, String disc, String image) {
        boolean insertData = mDatabaseHelper.addData(type, contact, event, disc, image);

        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        } else {
            toastMessage("Something went wrong");
        }
    }


    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}