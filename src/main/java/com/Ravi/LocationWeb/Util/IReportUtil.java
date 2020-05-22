package com.Ravi.LocationWeb.Util;

import java.io.File;
import java.util.List;

public interface IReportUtil {

	public void reportGenerate(String title,List<Object[]> data,File file);
}
