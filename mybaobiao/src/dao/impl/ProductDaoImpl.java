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

		dataset.addValue(152, "�ͻ�����", "aaaaa");

		JFreeChart chart = ChartFactory.createBarChart3D("�ͻ�����ͳ�Ʊ����ͻ��ȼ���", // ������
				"�ͻ�����", // X�����
				"����", // Y�����
				dataset, // ͼ����Ҫ������
				PlotOrientation.VERTICAL, // ͼ��ķ���ˮƽ���Ǵ�ֱ
				true, // �Ƿ���ʾͼ��
				true, // �Ƿ���ʾ������ʾ
				true);

		/**************************************** ���Ҷ��� ***********************************************************************************/
		// ��ȡͼ���������
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		// ��ȡX��
		CategoryAxis3D cAxis3D = (CategoryAxis3D) plot.getDomainAxis();
		// ��ȡY��
		NumberAxis3D nAxis3D = (NumberAxis3D) plot.getRangeAxis();
		// ��ȡ�������
		BarRenderer3D b3D = (BarRenderer3D) plot.getRenderer();

		/**************************************** �������� ***********************************************************************************/
		// �����������
		chart.getTitle().setFont(new Font("����", Font.BOLD, 18));
		// �����ӱ�������
		chart.getLegend().setItemFont(new Font("����", Font.BOLD, 13));
		// ������X������
		// ����X���ϵ�����
		cAxis3D.setTickLabelFont(new Font("����", Font.BOLD, 12));
		// ����X���������
		cAxis3D.setLabelFont(new Font("����", Font.BOLD, 12));
		// ������Y������
		// ����Y���ϵ�����
		nAxis3D.setTickLabelFont(new Font("����", Font.BOLD, 12));
		// ����Y���������
		nAxis3D.setLabelFont(new Font("����", Font.BOLD, 12));
		// ����Y���ϵĿ̶�
		// ����Y�᲻ʹ���Լ��Ŀ̶�
		nAxis3D.setAutoTickUnitSelection(false);
		// ���ÿ̶�
		NumberTickUnit unit = new NumberTickUnit(1);
		nAxis3D.setTickUnit(unit);
		// ����ͼ�εĿ��
		b3D.setMaximumBarWidth(0.05);
		// ���������ϵ�����
		b3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		// �������������ֿɼ�
		b3D.setBaseItemLabelsVisible(true);
		// �������������ֵ�����
		b3D.setBaseItemLabelFont(new Font("����", Font.BOLD, 15));

		/**************************************** ���� ****************************************************************************************/
		// ����
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
         }//����һ��pngͼƬ 
		
		path="images/BarChart/"+fName;
		
		

		return path;
	}

}
