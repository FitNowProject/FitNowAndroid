package pe.edu.upc.fitnow.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import pe.edu.upc.fitnow.R;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


/**
 * Created by Angel Alvarado on 23/11/2017.
 */

public class PhotoActivity extends AppCompatActivity {
    private Button uploadphoto;
    private StorageReference mstore;
    private static final int GALLERY_INTENT =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uploadphoto = (Button)findViewById(R.id.btn_upload);
        mstore = FirebaseStorage.getInstance().getReference();
        uploadphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,GALLERY_INTENT);
            }
        });
    }

}
