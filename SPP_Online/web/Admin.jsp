<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <h1><a href="HalamanUtama.jsp">Sistem Pembayaran Uang Sekolah</a></h1>
                <nav id="nav">
                    <ul>
                        <li class="special">
                            <a href="#menu" class="menuToggle"><span>Menu</span></a>
                            <div id="menu">
                                <ul>
                                    <li><a href="Admin.jsp">Home</a></li>
                                    <li><a href="BuatTagihan.jsp">Buat Tagihan</a></li>
                                    <li><a href="kirimPeringatan.jsp">Kirim Peringatan</a></li>
                                    <li><a href="UnggahPembayaran.jsp">Unggah Pembayaran</a></li>
                                    <li><a href="LihatStatus.jsp">Lihat Status</a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </nav>
            </header>

            <!-- Main -->
            <article id="main">
                <header>
                    <h2>Admin</h2>
                </header>
                <section class="wrapper style5">
                    <div class="inner">
                        <ul class="features">
                            <li class="icon fa-file">
                                <h3>Buat Tagihan</h3>
                                <a href="BuatTagihan.jsp" class="button fit">Buat Tagihan</a>
                            </li>
                            <li class="icon fa-send">
                                <h3>Kirim Peringatan</h3>
                                <a href="kirimPeringatan.jsp" class="button fit">Kirim Peringatan</a>
                            </li>
                            <li class="icon fa-upload">
                                <h3>Unggah Pembayaran</h3>
                                <a href="UnggahPembayaran.jsp" class="button fit">Unggah Pembayaran</a>
                            </li>
                        </ul>
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
