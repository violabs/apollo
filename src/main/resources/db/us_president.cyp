// Person Graph
CREATE (president:GovernmentRole {name:'President of the United States', wikiLink: 'https://en.wikipedia.org/wiki/President_of_the_United_States'})
CREATE (republican:PoliticalParty {name: 'Republican', affiliation: 'US', wikiLink: 'https://en.wikipedia.org/wiki/Republican_Party_(United_States)'})
CREATE (democrat:PoliticalParty {name: 'Democrat', affiliation: 'US', wikiLink: 'https://en.wikipedia.org/wiki/Democratic_Party_(United_States)'})
CREATE (whig:PoliticalParty {name: 'Whig', affiliation: 'US', wikiLink: 'https://en.wikipedia.org/wiki/Whig_Party_(United_States)'})
CREATE (nationalUnion:PoliticalParty {name: 'National Union', affiliation: 'US', wikiLink: 'https://en.wikipedia.org/wiki/National_Union_Party_(United_States)'})

CREATE (washington:Person {name:'George Washington', birth: '1732-00-00', death: '1799-00-00', wikiLink: 'https://en.wikipedia.org/wiki/George_Washington'})
CREATE (adams:Person {name:'John Adams', birth: '1735-00-00', death: '1826-00-00', wikiLink: 'https://en.wikipedia.org/wiki/John_Adams'})
CREATE (jefferson:Person {name:'Thomas Jefferson', birth: '1743-00-00', death: '1826-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Thomas_Jefferson'})
CREATE (madison:Person {name:'James Madison', birth: '1751-00-00', death: '1836-00-00', wikiLink: 'https://en.wikipedia.org/wiki/James_Madison'})
CREATE (monroe:Person {name:'James Monroe', birth: '1758-00-00', death: '1831-00-00', wikiLink: 'https://en.wikipedia.org/wiki/James_Monroe'})
CREATE (quincyAdams:Person {name:'John Quincy Adams', birth: '1767-00-00', death: '1848-00-00', wikiLink: 'https://en.wikipedia.org/wiki/John_Quincy_Adams'})
CREATE (jackson:Person {name:'Andrew Jackson', birth: '1767-00-00', death: '1845-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Andrew_Jackson'})
CREATE (vanBuren:Person {name:'Martin Van Buren', birth: '1782-00-00', death: '1862-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Martin_Van_Buren'})
CREATE (harrison:Person {name:'William Henry Harrison', birth: '1773-00-00', death: '1841-00-00', wikiLink: 'https://en.wikipedia.org/wiki/William_Henry_Harrison'})
CREATE (tyler:Person {name:'John Tyler', birth: '1790-00-00', death: '1862-00-00', wikiLink: 'https://en.wikipedia.org/wiki/John_Tyler'})
CREATE (polk:Person {name:'James K. Polk', birth: '1795-00-00', death: '1849-00-00', wikiLink: 'https://en.wikipedia.org/wiki/James_K._Polk'})
CREATE (taylor:Person {name:'Zachary Taylor', birth: '1784-00-00', death: '1850-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Zachary_Taylor'})
CREATE (fillmore:Person {name:'Millard Fillmore', birth: '1800-00-00', death: '1874-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Millard_Fillmore'})
CREATE (pierce:Person {name:'Franklin Pierce', birth: '1804-00-00', death: '1869-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Franklin_Pierce'})
CREATE (buchanan:Person {name:'James Buchanan', birth: '1791-00-00', death: '1868-00-00', wikiLink: 'https://en.wikipedia.org/wiki/James_Buchanan'})
CREATE (lincoln:Person {name:'Abraham Lincoln', birth: '1809-00-00', death: '1865-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Abraham_Lincoln'})
CREATE (johnson:Person {name:'Andrew Johnson', birth: '1808-00-00', death: '1875-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Andrew_Johnson'})
CREATE (grant:Person {name:'Ulysses S. Grant', birth: '1822-00-00', death: '1885-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Ulysses_S._Grant'})
CREATE (hayes:Person {name:'Rutherford B. Hayes', birth: '1822-00-00', death: '1893-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Rutherford_B._Hayes'})
CREATE (garfield:Person {name:'James A. Garfield', birth: '1831-00-00', death: '1881-00-00', wikiLink: 'https://en.wikipedia.org/wiki/James_A._Garfield'})
CREATE (arthur:Person {name:'Chester A. Arthur', birth: '1829-00-00', death: '1886-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Chester_A._Arthur'})
CREATE (cleveland:Person {name:'Grover Cleveland', birth: '1837-00-00', death: '1908-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Grover_Cleveland'})
CREATE (harris:Person {name:'Benjamin Harris', birth: '1833-00-00', death: '1901-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Benjamin_Harrison'})
CREATE (mcKinley:Person {name:'William McKinley', birth: '1843-00-00', death: '1901-00-00', wikiLink: 'https://en.wikipedia.org/wiki/William_McKinley'})
CREATE (roosevelt:Person {name:'Theodore Roosevelt', birth: '1858-00-00', death: '1919-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Theodore_Roosevelt'})
CREATE (taft:Person {name:'William Howard Taft', birth: '1857-00-00', death: '1930-00-00', wikiLink: 'https://en.wikipedia.org/wiki/William_Howard_Taft'})
CREATE (wilson:Person {name:'Woodrow Wilson', birth: '1856-00-00', death: '1924-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Woodrow_Wilson'})
CREATE (harding:Person {name:'Warren G. Harding', birth: '1865-00-00', death: '1923-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Warren_G._Harding'})
CREATE (coolidge:Person {name:'Calvin Coolidge', birth: '1872-00-00', death: '1933-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Calvin_Coolidge'})
CREATE (hoover:Person {name:'Herbert Hoover', birth: '1874-00-00', death: '1964-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Herbert_Hoover'})
CREATE (fdr:Person {name: 'Franklin D. Roosevelt', birth: '1882-00-00', death: '1945-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Franklin_D._Roosevelt'})
CREATE (truman:Person {name:'Harry S. Truman', birth: '1884-00-00', death: '1972-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Harry_S._Truman'})
CREATE (eisenhower:Person {name:'Dwight D. Eisenhower', birth: '1890-00-00', death: '1969-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Dwight_D._Eisenhower'})
CREATE (kennedy:Person {name:'John F. Kennedy', birth: '1917-00-00', death: '1963-00-00', wikiLink: 'https://en.wikipedia.org/wiki/John_F._Kennedy'})
CREATE (lbj:Person {name: 'Lyndon B. Johnson', birth: '1908-00-00', death: '1973-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Lyndon_B._Johnson'})
CREATE (nixon:Person {name:'Richard Nixon', birth: '1913-00-00', death: '1994-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Richard_Nixon'})
CREATE (ford:Person {name:'Gerald Ford', birth: '1913-00-00', death: '2006-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Gerald_Ford'})
CREATE (carter:Person {name:'Jimmy Carter', birth: '1924-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Jimmy_Carter'})
CREATE (reagan:Person {name:'Ronald Reagan', birth: '1911-00-00', death: '2004-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Ronald_Reagan'})
CREATE (hwBush:Person {name:'George H. W. Bush', birth: '1924-00-00', death: '2018-00-00', wikiLink: 'https://en.wikipedia.org/wiki/George_H._W._Bush'})
CREATE (clinton:Person {name:'Bill Clinton', birth: '1946-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Bill_Clinton'})
CREATE (wBush:Person {name:'George W. Bush', birth: '1946-00-00', wikiLink: 'https://en.wikipedia.org/wiki/George_W._Bush'})
CREATE (obama:Person {name:'Barack Obama', birth: '1961-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Barack_Obama'})
CREATE (trump:Person {name:'Donald Trump', birth: '1946-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Donald_Trump'})
CREATE (biden:Person {name:'Joe Biden', birth: '1942-00-00', wikiLink: 'https://en.wikipedia.org/wiki/Joe_Biden'})

CREATE (washington)-[:HELD_TITLE {startDate: '1789-04-30', endDate: '1797-03-04', timespan: '7 years, 10 months, and 4 days', changeReason: 'Retirement'}]->(president)
CREATE (adams)-[:HELD_TITLE {startDate: '1797-03-04', endDate: '1801-03-04', timespan: '4 years', changeReason: 'Vote'}]->(president)
CREATE (jefferson)-[:HELD_TITLE {startDate: '1801-03-04', endDate: '1809-03-04', timespan: '8 years', changeReason: 'Unknown'}]->(president)
CREATE (madison)-[:HELD_TITLE {startDate: '1809-03-04', endDate: '1817-03-04', timespan: '8 years', changeReason: 'Unknown'}]->(president)
CREATE (monroe)-[:HELD_TITLE {startDate: '1817-03-04', endDate: '1825-03-04', timespan: '8 years', changeReason: 'Unknown'}]->(president)
CREATE (quincyAdams)-[:HELD_TITLE {startDate: '1825-03-04', endDate: '1829-03-04', timespan: '4 years', changeReason: 'Vote'}]->(president)
CREATE (jackson)-[:HELD_TITLE {startDate: '1829-03-04', endDate: '1837-03-04', timespan: '8 years', changeReason: 'Unknown'}]->(president)
CREATE (vanBuren)-[:HELD_TITLE {startDate: '1837-03-04', endDate: '1841-03-04', timespan: '4 years', changeReason: 'Vote'}]->(president)
CREATE (harrison)-[:HELD_TITLE {startDate: '1841-03-04', endDate: '1841-04-04', timespan: '1 month', changeReason: 'Illness'}]->(president)
CREATE (tyler)-[:HELD_TITLE {startDate: '1841-04-04', endDate: '1845-03-04', timespan: '3 years and 11 months', changeReason: 'Vote'}]->(president)
CREATE (polk)-[:HELD_TITLE {startDate: '1845-03-04', endDate: '1849-03-04', timespan: '4 years', changeReason: 'Vote'}]->(president)
CREATE (taylor)-[:HELD_TITLE {startDate: '1849-03-04', endDate: '1850-07-09', timespan: '1 year, 4 months, and 5 days', changeReason: 'Illness'}]->(president)
CREATE (fillmore)-[:HELD_TITLE {startDate: '1850-07-09', endDate: '1853-03-04', timespan: '2 years, 7 months, and 23 days', changeReason: 'Vote'}]->(president)
CREATE (pierce)-[:HELD_TITLE {startDate: '1853-03-04', endDate: '1857-03-04', timespan: '4 years', changeReason: 'Vote'}]->(president)
CREATE (buchanan)-[:HELD_TITLE {startDate: '1857-03-04', endDate: '1861-03-04', timespan: '4 years', changeReason: 'Vote'}]->(president)
CREATE (lincoln)-[:HELD_TITLE {startDate: '1861-03-04', endDate: '1865-04-15', timespan: '4 years, 1 month, and 11 days', changeReason: 'Assassination'}]->(president)
CREATE (johnson)-[:HELD_TITLE {startDate: '1965-04-15', endDate: '1869-03-04', timespan: '3 years, 10 months, 17 days', changeReason: 'Vote'}]->(president)
CREATE (grant)-[:HELD_TITLE {startDate: '1969-03-04', endDate: '1877-03-04', timespan: '8 years', changeReason: 'Unknown'}]->(president)
CREATE (hayes)-[:HELD_TITLE {startDate: '1877-03-04', endDate: '1881-03-04', timespan: '4 years', changeReason: 'Vote'}]->(president)
CREATE (garfield)-[:HELD_TITLE {startDate: '1881-03-04', endDate: '1881-09-19', timespan: '6 months and 15 days', changeReason: 'Assassination'}]->(president)
CREATE (arthur)-[:HELD_TITLE {startDate: '1881-09-19', endDate: '1885-03-04', timespan: '3 years, 5 months, and 13 days', changeReason: 'Vote'}]->(president)
CREATE (cleveland)-[:HELD_TITLE {startDate: '1885-03-04', endDate: '1889-03-04', timespan: '4 years', changeReason: 'Vote'}]->(president)
CREATE (harrison)-[:HELD_TITLE {startDate: '1889-03-04', endDate: '1893-03-04', timespan: '4 years', changeReason: 'Vote'}]->(president)
CREATE (cleveland)-[:HELD_TITLE {startDate: '1893-03-04', endDate: '1897-03-04', timespan: '4 years', changeReason: 'Unknown'}]->(president)
CREATE (mcKinley)-[:HELD_TITLE {startDate: '1897-03-04', endDate: '1901-03-04', timespan: '4 years', changeReason: 'Vote'}]->(president)
CREATE (roosevelt)-[:HELD_TITLE {startDate: '1901-03-04', endDate: '1909-03-04', timespan: '8 years', changeReason: 'Unknown'}]->(president)
CREATE (taft)-[:HELD_TITLE {startDate: '1909-03-04', endDate: '1913-03-04', timespan: '4 years', changeReason: 'Vote'}]->(president)
CREATE (wilson)-[:HELD_TITLE {startDate: '1913-03-04', endDate: '1921-03-04', timespan: '8 years', changeReason: 'Unknown'}]->(president)
CREATE (harding)-[:HELD_TITLE {startDate: '1921-03-04', endDate: '1923-08-02', timespan: '2 years, 4 months, 29 days', changeReason: 'Cardiac Arrest'}]->(president)
CREATE (coolidge)-[:HELD_TITLE {startDate: '1923-08-02', endDate: '1929-03-04', timespan: '5 years, 7 months, 2 day', changeReason: 'Unknown'}]->(president)
CREATE (hoover)-[:HELD_TITLE {startDate: '1929-03-04', endDate: '1933-03-04', timespan: '4 years', changeReason: 'Vote'}]->(president)
CREATE (fdr)-[:HELD_TITLE {startDate: '1933-03-04', endDate: '1945-04-12', timespan: '12 years, 1 month, and 8 days', changeReason: 'Intracerebral Hemorrhage'}]->(president)
CREATE (truman)-[:HELD_TITLE {startDate: '1945-04-12', endDate: '1953-01-20', timespan: '7 years, 9 months, and 8 days', changeReason: 'Retirement'}]->(president)
CREATE (eisenhower)-[:HELD_TITLE {startDate: '1953-01-20', endDate: '1961-01-20', timespan: '4 years', changeReason: 'Vote'}]->(president)
CREATE (kennedy)-[:HELD_TITLE {startDate: '1961-01-20', endDate: '1963-11-22', timespan: '2 years, 10 months, and 2 days', changeReason: 'Assassination'}]->(president)
CREATE (lbj)-[:HELD_TITLE {startDate: '1963-11-22', endDate: '1969-01-20', timespan: '5 years, 1 month, and 29 days', changeReason: 'Term Limit'}]->(president)
CREATE (nixon)-[:HELD_TITLE {startDate: '1969-01-20', endDate: '1974-08-09', timespan: '5 years, 6 months, and 20 days', changeReason: 'Resigned'}]->(president)
CREATE (ford)-[:HELD_TITLE {startDate: '1974-08-09', endDate: '1977-01-20', timespan: '2 years, 5 months, and 11 days', changeReason: 'Vote'}]->(president)
CREATE (carter)-[:HELD_TITLE {startDate: '1977-01-20', endDate: '1981-01-20', timespan: '4 years', changeReason: 'Vote'}]->(president)
CREATE (reagan)-[:HELD_TITLE {startDate: '1981-01-20', endDate: '1989-01-20', timespan: '8 years', changeReason: 'Term Limit'}]->(president)
CREATE (hwBush)-[:HELD_TITLE {startDate: '1989-01-20', endDate: '1993-01-20', timespan: '4 years', changeReason: 'Vote'}]->(president)
CREATE (clinton)-[:HELD_TITLE {startDate: '1993-01-20', endDate: '2001-01-20', timespan: '8 years', changeReason: 'Term Limit'}]->(president)
CREATE (wBush)-[:HELD_TITLE {startDate: '2001-01-20', endDate: '2009-01-20', timespan: '8 years', changeReason: 'Term Limit'}]->(president)
CREATE (obama)-[:HELD_TITLE {startDate: '2009-01-20', endDate: '2017-01-20', timespan: '8 years', changeReason: 'Term Limit'}]->(president)
CREATE (trump)-[:HELD_TITLE {startDate: '2017-01-20', endDate: '2021-01-20', timespan: '4 years', changeReason: 'Vote'}]->(president)
CREATE (biden)-[:HELD_TITLE {startDate: '2017-01-20'}]->(president)
