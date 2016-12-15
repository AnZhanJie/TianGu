package dao.impl;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.DefaultCategoryDataset;

import util.BaseDao;
import dao.ProductDao;
import entity.Product;

public class ProductDaoImpl extends BaseDao implements ProductDao {

	@Override
	public String query(String path) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.addValue(152, "客户级别", "aaaaa");

		JFreeChart chart = ChartFactory.createBarChart3D("客户分析统计报表（客户等级）", // 主标题
				"客户级别", // X轴标题
				"数量", // Y轴表题
				dataset, // 图标需要的数据
				PlotOrientation.VERTICAL, // 图标的方向，水平还是垂直
				true, // 是否显示图例
				true, // 是否显示工具提示
				true);

		/**************************************** 查找对象 ***********************************************************************************/
		// 获取图标区域对象
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		// 获取X轴
		CategoryAxis3D cAxis3D = (CategoryAxis3D) plot.getDomainAxis();
		// 获取Y轴
		NumberAxis3D nAxis3D = (NumberAxis3D) plot.getRangeAxis();
		// 获取区域对象
		BarRenderer3D b3D = (BarRenderer3D) plot.getRenderer();

		/**************************************** 设置属性 ***********************************************************************************/
		// 处理表题乱码
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 18));
		// 处理子表题乱码
		chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 13));
		// 处理处理X轴乱码
		// 处理X轴上的乱码
		cAxis3D.setTickLabelFont(new Font("宋体", Font.BOLD, 12));
		// 处理X轴外的乱码
		cAxis3D.setLabelFont(new Font("宋体", Font.BOLD, 12));
		// 处理处理Y轴乱码
		// 处理Y轴上的乱码
		nAxis3D.setTickLabelFont(new Font("宋体", Font.BOLD, 12));
		// 处理Y轴外的乱码
		nAxis3D.setLabelFont(new Font("宋体", Font.BOLD, 12));
		// 处理Y轴上的刻度
		// 设置Y轴不使用自己的刻度
		nAxis3D.setAutoTickUnitSelection(false);
		// 设置刻度
		NumberTickUnit unit = new NumberTickUnit(1);
		nAxis3D.setTickUnit(unit);
		// 设置图形的宽度
		b3D.setMaximumBarWidth(0.05);
		// 处理柱体上的数字
		b3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		// 设置柱体上数字可见
		b3D.setBaseItemLabelsVisible(true);
		// 处理柱体上数字的字体
		b3D.setBaseItemLabelFont(new Font("宋体", Font.BOLD, 15));

		/**************************************** 启动 ****************************************************************************************/
		// 启动
		ChartFrame frame = new ChartFrame("BarChart", chart);
		frame.setVisible(true);
		frame.pack();
		
		
		 File dir = new File(path);   
         if (!dir.exists()) {  
             dir.mkdir();  
         }  
         String fName = String.valueOf(System.currentTimeMillis())+"BarChart.png";  
         File file = new File(path, fName);  
         try {
        	 System.out.println("file"+file);
        	 System.out.println("chart:"+chart.getAntiAlias());
             ChartUtilities.saveChartAsPNG(file, chart, 800, 450);
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }//生成一个png图片 
		
		path="images/BarChart/"+fName;
		
		

		return path;
	}

}
