<%@page import="model.Siswa"%>
<%@page import="model.Tagihan"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String nis = request.getParameter("nis");
    try {
            //Check kelengkapan input
            if (nis.equals("")) {
                throw new Exception("NIS Belum Terisi");
            }
            try {
                int formatNIS = Integer.parseInt(nis);
            } catch (Exception ej) {
                throw new Exception("Format NIS Salah");
            }
        } catch (Exception e) {
            RequestDispatcher dispatcher;
            request.setAttribute("error", e.getMessage());
            dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    
    Tagihan[] tg = Tagihan.getListStatusTagihan(nis);
    
    Siswa s = Siswa.getSiswa(nis);
    if (s.getNis()==null) {
            RequestDispatcher dispatcher;
            request.setAttribute("error", "Siswa tidak ditemukan");
            dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
%>
<!DOCTYPE HTML>
<!--
	Spectral by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>Sistem Pembayaran Uang Sekolah</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->

	</head>
	<body>

		<!-- Page Wrapper -->
			<div id="page-wrapper">

				<!-- Header -->
					<header id="header">
						<h1><a href="index.jsp">Sistem Pembayaran Uang Sekolah</a></h1>
						<nav id="nav">
							<ul>
								<li class="special">
									<a href="#menu" class="menuToggle"><span>Menu</span></a>
									<div id="menu">
										<ul>
											<li><a href="index.jsp">Home</a></li>
											<li><a href="LihatStatus.jsp">Lihat Status</a></li>
											<li><a href="Admin.jsp">Admin</a></li>
										</ul>
									</div>
								</li>
							</ul>
						</nav>
					</header>

				<!-- Main -->
					<article id="main">
						<section class="wrapper style5">
							<div class="inner">
                                                            <h2>Selamat datang, <%= s.getNama() %></h2>
                                                            <h3>Informasi Pembayaran:</h3>
                                                            <table>
                                                                <tr>
                                                                    <td>
                                                                        Tagihan bulan
                                                                    </td>
                                                                    <td>
                                                                        Jumlah tagihan
                                                                    </td>
                                                                    <td>
                                                                        Status pembayaran
                                                                    </td>
                                                                </tr>
                                                            <%for (int i = 0; i < tg.length; i++) { 
                                                                String status;
                                                                if (tg[i].isStatus_pembayaran()) {
                                                                        status="Sudah bayar";
                                                                    }
                                                                else{
                                                                        status="Belum bayar";
                                                                }
                                                            %>
                                                                    <tr>
                                                                    <td>
                                                                        <%= tg[i].getBulan_tagihan() %>
                                                                    </td>
                                                                    <td>
                                                                        <%= tg[i].getJumlah_pembayaran()%>
                                                                    </td>
                                                                    <td>
                                                                        
                                                                        <%= status %>
                                                                    </td>
                                                                </tr>
                                                                <%}%>
                                                            
                                                            </table>
                                                            
											
							</div>
						</section>
					</article>

				<!-- Footer -->
					<footer id="footer">
						<ul class="copyright">
							<li>2016 - SMA Sanata Dharma</li>
						</ul>
					</footer>

			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>

	</body>
</html>
