package com.example.ben.example.Data;

import com.github.mikephil.charting.components.AxisBase;

interface IAxisValueFormatter {
    String getFormattedValue(float value, AxisBase axis);
}
