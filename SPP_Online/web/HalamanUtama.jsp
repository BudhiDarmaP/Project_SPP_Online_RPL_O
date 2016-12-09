<%@page import="java.util.Timer"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.*"%>
<%@page import="controller.*"%>
<%--
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
                Date date1 = null; 
                Date date2 = null;
            try {
                date1 = fmt.parse("2016-10-19-08-52"); //Waktu untuk mengirim pemberitahuan
                date2 = fmt.parse("2016-10-19-08-51"); //Waktu untuk membuat tagihan
            } catch (ParseException ex) {
                
            }

                Timer time1 = new Timer(); // Timer untuk mengirim pemberitahuan
                Timer time2 = new Timer(); // Timer untuk mengirim pemberitahuan
                MengirimPemberitahuan p = new MengirimPemberitahuan();
                MembuatTagihan t = new MembuatTagihan();
               // time1.schedule(p, date1);
               // time2.schedule(t, date2);		
--%>
<!DOCTYPE HTML>
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
    <body class="landing">

        <!-- Page Wrapper -->
        <div id="page-wrapper">

            <!-- Header -->
            <header id="header" class="alt">
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

            <!-- Banner -->
            <section id="banner">
                <div class="inner">
                    <h2>Sistem Pembayaran Uang Sekolah</h2>
                    <p>SMA Sanata Dharma<br /></p>
                </div>
                <a href="#login" class="more scrolly">Masuk</a>
            </section>

            <!-- login -->
            <section id="login" class="wrapper style2 special">
                <div class="inner">
                    <header class="major">
                        <h2>Selamat datang!</h2>
                        <p>Masuk Sebagai:</p>
                    </header>
                    <ul class="features">
                        <li class="icon fa-search">
                            <h3>Lihat Status</h3>
                            <a href="LihatStatus.jsp" class="button fit">Lihat Status</a>
                        </li>
                        <li class="icon fa-sign-in">
                            <h3>Admin</h3>
                            <a href="Admin.jsp" class="button fit">Admin</a>
                        </li>
                    </ul>
                </div>
            </section>



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
