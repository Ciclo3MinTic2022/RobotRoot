package com.RobotRoot;

import com.RobotRoot.Entities.Empleado;
import com.RobotRoot.Entities.Empresa;
import com.RobotRoot.Entities.MovimientoDinero;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RobotRootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobotRootApplication.class, args);

		MovimientoDinero mvd1=new MovimientoDinero(45875,"Compra insumos");
		Empleado emp1= new Empleado("Adan", "adan12345@misena.edu.co","Cocacola","administrador", mvd1);
		Empresa ep1=new Empresa("Cocalola", "Cr50#20-25", 3012251, "1235478-NIT", emp1);

		System.out.println(ep1.toString());

	}
}
