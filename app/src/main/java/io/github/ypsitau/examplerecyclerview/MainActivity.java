package io.github.ypsitau.examplerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
	private RecyclerView recyclerView;
	private RecyclerView.Adapter adapter;
	private RecyclerView.LayoutManager layoutManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		recyclerView = findViewById(R.id.recyclerView);
		recyclerView.setHasFixedSize(true);
		layoutManager = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(layoutManager);
		String dataSet[] = new String[]{
				"Sonja Collier",
				"Arnold Lyons",
				"Rosemarie Bailey",
				"Karla Fitzgerald",
				"Jenny Andrews",
				"Vincent Cummings",
				"Austin Larson",
				"Margarita Burgess",
				"Evan Powers",
				"Jessica Rodriguez",
				"Della Hunter",
				"Derrick Tran",
				"Ismael Carroll",
				"Jermaine Moody",
				"Charlotte Hamilton",
				"Alice Oliver",
				"Kerry Foster",
				"Sergio Ferguson",
				"Clint Lawrence",
				"Alma Allen",
				"Willis Barton",
				"Olivia Peters",
				"Marguerite Cook",
				"Kent Cunningham",
				"Shannon Hayes",
				"Rex Rice",
				"Marty Haynes",
				"Mark Long",
				"Lyle Sanchez",
				"Leslie Riley",
				"Maria Graves",
				"Juan Scott",
				"Arthur Warner",
				"Tommie Hunt",
				"Craig Bell",
				"Kathleen Pratt",
				"Wilfred Garrett",
				"Vera Goodwin",
				"Morris Tucker",
				"Lola Parker",
				"Travis Griffith",
				"Deborah Chapman",
				"Doreen Ray",
				"Cesar Roberts",
				"Lucia Barnes",
				"Adrian Osborne",
				"Jason Clark",
				"Kathy Obrien",
				"Francis Copeland",
				"Kim Mcdonald",
				"Salvatore Farmer",
				"Ellis Hall",
				"Charles Casey",
				"Brandi Becker",
				"Hugo Weber",
				"Randolph Turner",
				"Steve Price",
				"Dale Coleman",
				"Lewis Mckinney",
				"Ian Lowe",
				"Kenneth Medina",
				"Joe Bishop",
				"Kristi Drake",
				"Angelina Bowen",
				"Lana Newman",
				"Leon Boone",
				"Holly Adams",
				"Cheryl Wagner",
				"Lawrence Wheeler",
				"Mona Williamson",
				"Jean Ortiz",
				"Hugh Baldwin",
				"Francisco Walker",
				"Doris Robinson",
				"Joshua Hoffman",
				"Emmett Owens",
				"Alison Nguyen",
				"Ernest Payne",
				"Sonya Chavez",
				"Mercedes Silva",
				"Carlton Walsh",
				"Shari Maxwell",
				"Judith Fleming",
				"Edwin Greene",
				"Marion Steele",
				"Robyn Floyd",
				"Edith Townsend",
				"Tyler Ballard",
				"Pearl Ingram",
				"Diana Kelly",
				"Blanche Beck",
				"Josefina Lucas",
				"Evelyn Ellis",
				"Pauline Mckenzie",
				"Bessie Mendoza",
				"Carmen Hughes",
				"Jorge Ross",
				"Grace Adkins",
				"Flora Castillo",
				"Emily Wright",
		};
		adapter = new MyAdapter(dataSet);
		recyclerView.setAdapter(adapter);
	}
}
