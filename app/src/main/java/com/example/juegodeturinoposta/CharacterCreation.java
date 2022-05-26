package com.example.juegodeturinoposta;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.juegodeturinoposta.model.DataBaseManager;
import com.example.juegodeturinoposta.model.PlayableCharacter;

public class CharacterCreation extends AppCompatActivity {

    PlayableCharacter mainChar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_creation);

        Button btnUploadImgChar = findViewById(R.id.btnSelectImg);
        Button btnContinue = findViewById(R.id.btnContinueCharacter);
        EditText nameChar = findViewById(R.id.edtTxtPlayerName);
        EditText atkPtsInicial = findViewById(R.id.editTextAtkPtsSlct);
        EditText dfcPtsInicial = findViewById(R.id.editTextDfcPtsSlct);
        EditText aglPtsInicial = findViewById(R.id.editTextAglPtsSlct);
        TextView textViewError = findViewById(R.id.textViewErrorCharCreation);



        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameChar.getText().toString();
                String atkPts = atkPtsInicial.getText().toString();
                String dfcPts = dfcPtsInicial.getText().toString();
                String aglPts = aglPtsInicial.getText().toString();
                int valueAtk = 0;
                int valueDfc = 0;
                int valueAgl = 0;

                if (!"".equals(atkPts)) {
                    valueAtk = Integer.parseInt(atkPts);
                }

                if (!"".equals(dfcPts)) {
                    valueDfc = Integer.parseInt(dfcPts);
                }

                if (!"".equals(aglPts)) {
                    valueAgl = Integer.parseInt(aglPts);
                }

                if (valueAgl + valueAtk + valueDfc > 13) {
                    textViewError.setTextColor(ContextCompat.getColor(CharacterCreation.this, R.color.red_opal));
                    textViewError.setText("You can only distribute up to 13 Skill Points");
                } else if (valueAgl + valueAtk + valueDfc < 13) {
                    textViewError.setTextColor(ContextCompat.getColor(CharacterCreation.this, R.color.red_opal));
                    textViewError.setText("Please distribute all your Skill Points");

                } else
                    if (name.equals("")){

                    textViewError.setTextColor(ContextCompat.getColor(CharacterCreation.this, R.color.red_opal));
                    textViewError.setText("Please name your character");

                }
                    else {
                    mainChar = new PlayableCharacter(name, valueAtk, valueDfc, valueAgl);
                    DataBaseManager dataBaseManager = new DataBaseManager(CharacterCreation.this);
                        textViewError.setTextColor(ContextCompat.getColor(CharacterCreation.this, R.color.green_sea));
                        textViewError.setText(mainChar.getName() + " creado correctamente");
                        dataBaseManager.insert(mainChar);
                    }

            }
        });


        btnUploadImgChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 3);
            }
        });

    }

    //Como carajo asignarle la foto?

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            ImageView imageView = findViewById(R.id.imgViewSelectPhoto);
            imageView.setImageURI(selectedImage);
            mainChar.setCharImg(selectedImage);
        }
    }
}
