<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Wedding Invitation</title>
    <style>
        /* Body & Background */
        body {
            margin: 0;
            height: 100vh;
            display: flex;
            justify-content: left;
            align-items: left;
            background-image: url('<c:url value="/image/indexpagebg.png"/>');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            font-family: Arial, sans-serif;
        }

        /* Container for heading and form */
        .head {
            display: flex;
            flex-direction: column; /* fixed typo */
            justify-content: center;
            align-items: center;
            gap: 30px;
            text-align: center;
            background: rgba(255, 255, 255, 0.1); /* optional: slight overlay */
            padding: 40px;
            border-radius: 20px;
        }

        /* Heading */
        .head h1 {
            font-size: 2.5rem;
            color: #8B0000;
            margin: 0;
        }

        /* Name input field */
        .name-input {
            width: 300px;
            padding: 14px 20px;
            font-size: 16px;
            border: 2px solid #8B0000;
            border-radius: 30px;
            outline: none;
            text-align: center;
            transition: all 0.3s ease;
        }

        .name-input:focus {
            border-color: gold;
            box-shadow: 0 0 10px gold;
        }

        /* Submit button */
        .invite-btn {
            background: linear-gradient(135deg, #8B0000, #4B0000);
            color: white;
            padding: 14px 30px;
            font-size: 18px;
            font-weight: 700;
            border: none;
            border-radius: 40px;
            cursor: pointer;
            transition: all 0.3s ease;
        }

        .invite-btn:hover {
            transform: scale(1.1);
            box-shadow: 0 10px 25px rgba(0,0,0,0.4);
        }

        /* Responsive adjustments */
        @media (max-width: 400px) {
            .name-input {
                width: 90%;
            }
            .head {
                padding: 20px;
                gap: 20px;
            }
        }
    </style>
</head>
<body>
    <div class="head">
        <h1>🙏 Shree Ganeshaya Namah 🙏</h1>
        <form action="welcome" method="post">
            <input type="text" name="name" placeholder="Enter Your Name" required class="name-input"/>
            <button type="submit" class="invite-btn">Open Invitation</button>
        </form>
    </div>
</body>
</html>
