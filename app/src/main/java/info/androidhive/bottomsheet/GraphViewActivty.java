package info.androidhive.bottomsheet;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;

public class GraphViewActivty extends AppCompatActivity {
    LineChart chart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_view_activty);
        chart = findViewById(R.id.chart);

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 434));
        entries.add(new Entry(1, 12));
        entries.add(new Entry(2, 233));
        entries.add(new Entry(3, 13));
        entries.add(new Entry(4, 62));
        entries.add(new Entry(5, 234));
        entries.add(new Entry(6, 483));
        entries.add(new Entry(7, 335));
        entries.add(new Entry(8, 10));
        entries.add(new Entry(9, 42));
        entries.add(new Entry(10, 511));
        entries.add(new Entry(11, 16));
        entries.add(new Entry(12, 639));
        entries.add(new Entry(13, 233));
        entries.add(new Entry(14, 8));
        entries.add(new Entry(15, 33));
        entries.add(new Entry(16, 130));
        entries.add(new Entry(17, 354));
        entries.add(new Entry(18, 11));
        entries.add(new Entry(19, 1));
        entries.add(new Entry(20, 636));
        entries.add(new Entry(21, 42));
        entries.add(new Entry(22, 83));
        entries.add(new Entry(23, 33));
        entries.add(new Entry(24, 130));


        LineDataSet dataSet = new LineDataSet(entries, "Customized values");
        dataSet.setColor(ContextCompat.getColor(this, R.color.graph_color));
        dataSet.setDrawValues(false);
        dataSet.setDrawCircles(false);
        dataSet.setValueTextColor(ContextCompat.getColor(this, R.color.graph_color));
        chart.getAxisLeft().setDrawGridLines(false);
        chart.getXAxis().setDrawGridLines(false);
        chart.getAxisLeft().setTextColor(ContextCompat.getColor(this, R.color.graph_color)); // left y-axis
        chart.getXAxis().setTextColor(ContextCompat.getColor(this, R.color.graph_color));
        chart.getLegend().setTextColor(ContextCompat.getColor(this, R.color.graph_color));
        //****
        // Controlling X axis
        XAxis xAxis = chart.getXAxis();
        // Set the xAxis position to bottom. Default is top
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //Customizing x axis value
        final String[] months = new String[]{"Jan", "Feb", "Mar", "Apr","May","Jun","July","Aug","Sep","Oct","Nov","Dec"};

        IAxisValueFormatter formatter = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return value+ "am";
            }
        };
        xAxis.setGranularity(1f); // minimum axis-step (interval) is 1
        xAxis.setValueFormatter(formatter);

        //***
        // Controlling right side of y axis
        YAxis yAxisRight = chart.getAxisRight();
        yAxisRight.setEnabled(false);

        //***
        // Controlling left side of y axis
        YAxis yAxisLeft = chart.getAxisLeft();
        yAxisLeft.setGranularity(1f);
        CustomMarkerView mv = new CustomMarkerView(this, R.layout.custom_marker_view_layout);

// set the marker to the chart
        chart.setMarker(mv);

        // Setting Data
        LineData data = new LineData(dataSet);
        chart.setData(data);
        chart.animateX(250);

        //refresh
        chart.invalidate();
    }
}
