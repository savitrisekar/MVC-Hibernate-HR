/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontroller;

import java.util.List;
import models.Employee;

/**
 *
 * @author ACER
 */
public interface IEmployeeController {
    
    /** getAll method untuk mengambil semua data pada tabel Employee*/
    public List<Employee> getAll();
    
    /** Method yang digunakan untk mendapatkan dan menyeleksi data dari tabel Employee*/
    public Employee getById(String id);
    
    /** Method yang digunakan untuk mendapatkan dan menyeleksi data dari tabel Employee*/
    public List<Employee> search(Object key);
    
    /** Method yang digunakan untuk memasukkan data ke dalam tabel Employee*/
    public String insert(String id, String firstName, String email, String lastName);
    
    /** Method yang digunakan untuk mengganti nilai data di dalam tabel Employee*/
    public String update(String id, String firstName, String lastName, String salary);
    
    /** Method yang digunakan untuk menghapus suatu baris data sesuai id masukan*/
    public String delete(String id);
    
}
