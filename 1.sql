CREATE PROCEDURE apply_pass(IN h_no_ VARCHAR ,IN h_size_ VARCHAR ,IN h_r_ VARCHAR ,IN h_n_ INT)
AS
BEGIN
 insert into  bring_log(h_no,h_size,h_r,h_n,h_bring_num,h_bing_datetime,positon_id) values (SELECT h_no,h_size,h_r,h_n,h_bring_num,h_bing_datetime,positon_id from proc_kc WHERE h_no =h_no_ AND h_size=h_size_ AND h_r=h_r_ AND h_n=h_n_)
 insert into machinary_bring (h_no,h_size,h_r,h_n,h_bring_num,h_bring_datetime) values (SELECT h_no,h_size,h_r,h_n,h_bring_num,h_bring_datetime FROM proc_kc WHERE h_no =h_no_ AND h_size=h_size_ AND h_r=h_r_ AND h_n=h_n_)
 DECLARE h_bring_num_tmp INT
 SET h_bring_num_tmp = (select h_bring_num from machinary_bring WHERE h_no =h_no_ AND h_size=h_size_ AND h_r=h_r_ AND h_n=h_n_)
 update halfproduct_kc
  set h_num_now = h_num_now - h_bring_num_tmp
  where h_num= h_num_
  DELETE FROM proc_kc where h_no =h_no_ AND h_size=h_size_ AND h_r=h_r_ AND h_n=h_n_
END