package com.kos.vectordrawableview;

import android.os.Bundle;
import android.view.View;

import com.kos.svgpreview.xml.VectorDrawableReader;
import com.kos.svgpreview.xml.parser.XmlVectorDrawable;
import com.kos.svgpreview.xml.parser.XmlView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				String text = "<vector xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
						"        android:width=\"24dp\"\n" +
						"        android:height=\"24dp\"\n" +
						"        android:viewportWidth=\"24.0\"\n" +
						"        android:viewportHeight=\"24.0\">\n" +
						"    <path\n" +
						"        android:fillColor=\"#FF000000\"\n" +
						"        android:pathData=\"M19.35,10.04C18.67,6.59 15.64,4 12,4 9.11,4 6.6,5.64 5.35,8.04 2.34,8.36 0,10.91 0,14c0,3.31 2.69,6 6,6h13c2.76,0 5,-2.24 5,-5 0,-2.64 -2.05,-4.78 -4.65,-4.96z\"/>\n" +
						"</vector>\n";

				InputStream targetStream = new ByteArrayInputStream(text.getBytes());

				//Load from file or input stream
				//VectorDrawableReader.loadFromVectorDrawableFile(new File("..."));
				XmlVectorDrawable.VectorDrawableCompatState res = VectorDrawableReader.loadFromVectorDrawableStream(targetStream);
				XmlView imageView = findViewById(R.id.image);
				imageView.fromVectorState(res);

			}
		});
	}
}
