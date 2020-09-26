package com.bestseller.wss.service.impl;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.bestseller.wss.constant.Constant;
import com.bestseller.wss.service.CompleteQty2XlsxService;
import com.fr.base.operator.common.CommonOperator;
import com.fr.chart.activator.ChartBaseActivator;
import com.fr.cluster.engine.activator.standalone.StandaloneModeActivator;
import com.fr.config.activator.BaseDBActivator;
import com.fr.config.activator.ConfigurationActivator;
import com.fr.env.operator.CommonOperatorImpl;
import com.fr.general.I18nResource;
import com.fr.health.activator.ModuleHealActivator;
import com.fr.io.TemplateWorkBookIO;
import com.fr.io.exporter.excel.stream.StreamExcel2007Exporter;
import com.fr.main.impl.WorkBook;
import com.fr.module.tool.ActivatorToolBox;
import com.fr.report.ReportActivator;
import com.fr.report.RestrictionActivator;
import com.fr.report.module.ReportBaseActivator;
import com.fr.report.write.WriteActivator;
import com.fr.scheduler.SchedulerActivator;
import com.fr.stable.WriteActor;
import com.fr.store.StateServiceActivator;
import com.fr.workspace.simple.SimpleWork;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CompleteQty2XlsxServiceImp implements CompleteQty2XlsxService{
	@Override
	public String completeQty2Xlsx(String frHomeString, String reportNameString) throws Exception{
		log.info("Export service Start");
		// TODO Auto-generated method stub
		com.fr.module.Module module = ActivatorToolBox.simpleLink(new BaseDBActivator(),
                new ConfigurationActivator(),
                new StandaloneModeActivator(),
                new ModuleHealActivator(),
                new StateServiceActivator(),
                new SchedulerActivator(),
                new ReportBaseActivator(),
                new RestrictionActivator(),
                new ReportActivator(),
                new WriteActivator(),
                new ChartBaseActivator());
        SimpleWork.supply(CommonOperator.class, new CommonOperatorImpl());
        //帆软所在路径
        String envpath = frHomeString;
        SimpleWork.checkIn(envpath);
        I18nResource.getInstance();
        module.start();
        Map<String, Object> parameterMap = new HashMap<String, Object>();
        SimpleDateFormat fileName = new SimpleDateFormat(Constant.TIME_FORMAT);
        
        try {
        	 WorkBook workbook = (WorkBook) TemplateWorkBookIO.readTemplateWorkBook(reportNameString);
        	// 定义输出流
             String outputUrl=Constant.OUTPUT_RUL;
             FileOutputStream outputStream;
             outputStream = new FileOutputStream(new java.io.File(outputUrl+fileName+".xlsx"));
             StreamExcel2007Exporter<Object> excelExport = new StreamExcel2007Exporter<Object>(); 
             excelExport.export(outputStream, workbook.execute(parameterMap, new WriteActor()));
             outputStream.close();
             module.stop();
			
		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
            module.stop();
            throw e;
		}finally {
            SimpleWork.checkOut();
        }
        log.info("Export service done");
		return null;
	}
	
}
